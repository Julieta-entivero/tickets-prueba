package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.LoginPage;
import com.ticketsprueba.pages.InventoryPage;
import com.ticketsprueba.pages.CartPage;
import com.ticketsprueba.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC-003: Validacion del Carrito de Compras
 * Tickets: SHOP-301, SHOP-302
 * Modulo: Carrito
 * Precondicion: usuario logueado
 */
public class TC003_CartTest extends BaseTest {

    private InventoryPage inventoryPage;
    private final String USER = ConfigReader.get("standard.user");
    private final String PASS = ConfigReader.get("standard.password");

    @BeforeMethod
    public void loginAndInit() {
        LoginPage login = new LoginPage(driver);
        inventoryPage = login.loginAs(USER, PASS);
    }

    @Test(description = "SHOP-301 | Agregar producto al carrito desde catalogo")
    public void TC003_agregarProducto() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartCount(), "1");
    }

    @Test(description = "SHOP-301 | Agregar multiples productos al carrito")
    public void TC003_agregarMultiplesProductos() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.addItemToCartByName("Sauce Labs Bike Light");
        inventoryPage.addItemToCartByName("Sauce Labs Bolt T-Shirt");

        Assert.assertEquals(inventoryPage.getCartCount(), "3");
    }

    @Test(description = "SHOP-301 | Remover producto desde el catalogo")
    public void TC003_removerProductoDesdeCatalogo() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartCount(), "1");

        inventoryPage.removeItemByName("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartCount(), "0");
    }

    @Test(description = "SHOP-302 | Verificar producto agregado en pagina del carrito")
    public void TC003_verificarProductoEnCarrito() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        CartPage cart = inventoryPage.goToCart();

        Assert.assertEquals(cart.getCartItemCount(), 1);
        Assert.assertEquals(cart.getItemName(0), "Sauce Labs Backpack");
    }

    @Test(description = "SHOP-302 | Remover producto desde pagina del carrito")
    public void TC003_removerProductoDesdeCarrito() {
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.addItemToCartByName("Sauce Labs Bike Light");

        CartPage cart = inventoryPage.goToCart();
        Assert.assertEquals(cart.getCartItemCount(), 2);

        cart.removeItemByName("Sauce Labs Backpack");
        Assert.assertEquals(cart.getCartItemCount(), 1);
    }

    @Test(description = "SHOP-302 | Carrito vacio no tiene items")
    public void TC003_carritoVacio() {
        CartPage cart = inventoryPage.goToCart();
        Assert.assertEquals(cart.getCartItemCount(), 0);
    }

    @Test(description = "SHOP-302 | Volver al catalogo desde el carrito")
    public void TC003_volverACatalogo() {
        CartPage cart = inventoryPage.goToCart();
        InventoryPage back = cart.continueShopping();
        Assert.assertTrue(back.isPageLoaded());
    }
}
