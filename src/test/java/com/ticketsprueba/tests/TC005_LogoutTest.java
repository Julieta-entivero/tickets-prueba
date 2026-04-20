package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.LoginPage;
import com.ticketsprueba.pages.InventoryPage;
import com.ticketsprueba.utils.ConfigReader;
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
    private final String USER = ConfigReader.get("standard.user");
    private final String PASS = ConfigReader.get("standard.password");

    @BeforeMethod
    public void loginAndInit() {
        LoginPage login = new LoginPage(driver);
        inventoryPage = login.loginAs(USER, PASS);
    }

    @Test(description = "SHOP-501 | Logout redirige al login")
    public void TC005_logoutExitoso() {
        inventoryPage.logout();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
            "No se redirigio al login despues del logout");
    }

    @Test(description = "SHOP-501 | URL despues de logout no contiene inventory")
    public void TC005_urlDespuesDeLogout() {
        inventoryPage.logout();
        Assert.assertFalse(driver.getCurrentUrl().contains("/inventory.html"),
            "La URL todavia contiene /inventory.html despues del logout");
    }
}
