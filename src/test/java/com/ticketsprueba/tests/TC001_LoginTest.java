package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.LoginPage;
import com.ticketsprueba.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC-001: Validacion de Login
 * Ticket: SHOP-101
 * Modulo: Autenticacion
 * Precondicion: usuario en pagina de login
 */
public class TC001_LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(driver);
    }

    @Test(description = "SHOP-101 | Login exitoso con credenciales validas")
    public void TC001_loginConUsuarioValido() {
        InventoryPage inventory = loginPage.loginAs("standard_user", "secret_sauce");
        Assert.assertTrue(inventory.isPageLoaded(),
            "La pagina de productos no cargo despues del login");
    }

    @Test(description = "SHOP-101 | Login con usuario incorrecto muestra error")
    public void TC001_loginConUsuarioIncorrecto() {
        loginPage.loginExpectingError("usuario_falso", "secret_sauce");
        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"));
    }

    @Test(description = "SHOP-101 | Login con password incorrecta muestra error")
    public void TC001_loginConPasswordIncorrecta() {
        loginPage.loginExpectingError("standard_user", "password_mal");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test(description = "SHOP-101 | Login con campos vacios - usuario")
    public void TC001_loginSinUsuario() {
        loginPage.loginExpectingError("", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test(description = "SHOP-101 | Login con campos vacios - password")
    public void TC001_loginSinPassword() {
        loginPage.loginExpectingError("standard_user", "");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }

    @Test(description = "SHOP-102 | Usuario bloqueado no puede acceder")
    public void TC001_loginUsuarioBloqueado() {
        loginPage.loginExpectingError("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }
}
