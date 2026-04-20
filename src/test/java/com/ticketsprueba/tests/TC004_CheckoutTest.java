package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.*;
import com.ticketsprueba.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC-004: Validacion del flujo de Checkout
 * Tickets: SHOP-401, SHOP-402, SHOP-403
 * Modulo: Checkout
 * Precondicion: usuario logueado con productos en carrito
 */
public class TC004_CheckoutTest extends BaseTest {

    private InventoryPage inventoryPage;
    private final String USER = ConfigReader.get("standard.user");
    private final String PASS = ConfigReader.get("standard.password");

    @BeforeMethod
    public void loginAndInit() {
        LoginPage login = new LoginPage(driver);
        inventoryPage = login.loginAs(USER, PASS);
    }

    @Test(description = "SHOP-401 | Checkout completo E2E - un producto")
    public void TC004_checkoutCompletoUnProducto() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");

        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();

        stepOne.fillForm("Julieta", "Entivero", "5000");
        CheckoutStepTwoPage stepTwo = stepOne.continueToStepTwo();

        Assert.assertNotNull(stepTwo.getTotal());
        Assert.assertTrue(stepTwo.getTotal().contains("$"));

        CheckoutCompletePage complete = stepTwo.finish();
        Assert.assertTrue(complete.isOrderComplete());
        Assert.assertEquals(complete.getSuccessHeader(), "Thank you for your order!");
    }

    @Test(description = "SHOP-401 | Checkout completo E2E - multiples productos")
    public void TC004_checkoutCompletoVariosProductos() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.addItemToCartByName("Sauce Labs Bike Light");

        CartPage cart = inventoryPage.goToCart();
        Assert.assertEquals(cart.getCartItemCount(), 2);

        CheckoutStepOnePage stepOne = cart.checkout();
        stepOne.fillForm("Julieta", "Entivero", "5000");
        CheckoutStepTwoPage stepTwo = stepOne.continueToStepTwo();

        CheckoutCompletePage complete = stepTwo.finish();
        Assert.assertTrue(complete.isOrderComplete());
    }

    @Test(description = "SHOP-402 | Checkout sin nombre muestra error")
    public void TC004_checkoutSinNombre() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();

        stepOne.fillForm("", "Entivero", "5000");
        stepOne.clickContinue();

        Assert.assertTrue(stepOne.isErrorDisplayed());
        Assert.assertTrue(stepOne.getErrorMessage().contains("First Name is required"));
    }

    @Test(description = "SHOP-402 | Checkout sin apellido muestra error")
    public void TC004_checkoutSinApellido() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();

        stepOne.fillForm("Julieta", "", "5000");
        stepOne.clickContinue();

        Assert.assertTrue(stepOne.isErrorDisplayed());
        Assert.assertTrue(stepOne.getErrorMessage().contains("Last Name is required"));
    }

    @Test(description = "SHOP-402 | Checkout sin codigo postal muestra error")
    public void TC004_checkoutSinZip() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();

        stepOne.fillForm("Julieta", "Entivero", "");
        stepOne.clickContinue();

        Assert.assertTrue(stepOne.isErrorDisplayed());
        Assert.assertTrue(stepOne.getErrorMessage().contains("Postal Code is required"));
    }

    @Test(description = "SHOP-403 | Cancelar checkout vuelve al carrito")
    public void TC004_cancelarCheckout() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();
        CartPage backToCart = stepOne.cancel();

        Assert.assertEquals(backToCart.getCartItemCount(), 1);
    }

    @Test(description = "SHOP-403 | Despues de comprar, volver al home")
    public void TC004_volverAlHomeDespuesDeComprar() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();
        CheckoutStepOnePage stepOne = cart.checkout();
        stepOne.fillForm("Julieta", "Entivero", "5000");
        CheckoutStepTwoPage stepTwo = stepOne.continueToStepTwo();
        CheckoutCompletePage complete = stepTwo.finish();

        InventoryPage home = complete.backToHome();
        Assert.assertTrue(home.isPageLoaded());
    }
}
