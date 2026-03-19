package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.LoginPage;
import com.ticketsprueba.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC-005: Validacion de Logout
 * Ticket: SHOP-501
 * Modulo: Autenticacion
 * Precondicion: usuario logueado
 */
public class TC005_LogoutTest extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void loginAndInit() {
        LoginPage login = new LoginPage(driver);
        inventoryPage = login.loginAs("standard_user", "secret_sauce");
    }

    @Test(description = "SHOP-501 | Logout redirige al login")
    public void TC005_logoutExitoso() {
        inventoryPage.logout();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
            "No se redirigeo al login despues del logout");
    }

    @Test(description = "SHOP-501 | URL despues de logout es la de login")
    public void TC005_urlDespuesDeLogout() {
        inventoryPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"),
            "La URL no corresponde al login");
    }
}
