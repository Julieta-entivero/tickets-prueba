package com.ticketsprueba.tests;

import com.ticketsprueba.base.BaseTest;
import com.ticketsprueba.pages.LoginPage;
import com.ticketsprueba.pages.InventoryPage;
import com.ticketsprueba.pages.ItemDetailPage;
import com.ticketsprueba.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TC-002: Validacion del Inventario de Productos
 * Tickets: SHOP-201, SHOP-202, SHOP-203
 * Modulo: Catalogo
 * Precondicion: usuario logueado
 */
public class TC002_InventoryTest extends BaseTest {

    private InventoryPage inventoryPage;
    private final String USER = ConfigReader.get("standard.user");
    private final String PASS = ConfigReader.get("standard.password");

    @BeforeMethod
    public void loginAndInit() {
        LoginPage login = new LoginPage(driver);
        inventoryPage = login.loginAs(USER, PASS);
    }

    @Test(description = "SHOP-201 | Se muestran 6 productos en el catalogo")
    public void TC002_verificarCantidadProductos() {
        Assert.assertEquals(inventoryPage.getItemCount(), 6,
            "La cantidad de productos no es la esperada");
    }

    @Test(description = "SHOP-201 | Titulo de la pagina dice Products")
    public void TC002_verificarTituloPagina() {
        Assert.assertTrue(inventoryPage.isPageLoaded());
    }

    @Test(description = "SHOP-202 | Ordenar por precio menor a mayor funciona")
    public void TC002_ordenarPorPrecioAsc() {
        inventoryPage.sortBy("Price (low to high)");
        List<Double> prices = inventoryPage.getItemPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) <= prices.get(i + 1),
                "Precio " + prices.get(i) + " no es menor o igual a " + prices.get(i + 1));
        }
    }

    @Test(description = "SHOP-202 | Ordenar por precio mayor a menor funciona")
    public void TC002_ordenarPorPrecioDesc() {
        inventoryPage.sortBy("Price (high to low)");
        List<Double> prices = inventoryPage.getItemPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) >= prices.get(i + 1),
                "Precio " + prices.get(i) + " no es mayor o igual a " + prices.get(i + 1));
        }
    }

    @Test(description = "SHOP-202 | Ordenar por nombre A-Z funciona")
    public void TC002_ordenarPorNombreAZ() {
        inventoryPage.sortBy("Name (A to Z)");
        List<String> names = inventoryPage.getItemNames();

        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) <= 0);
        }
    }

    @Test(description = "SHOP-202 | Ordenar por nombre Z-A funciona")
    public void TC002_ordenarPorNombreZA() {
        inventoryPage.sortBy("Name (Z to A)");
        List<String> names = inventoryPage.getItemNames();

        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) >= 0);
        }
    }

    @Test(description = "SHOP-203 | Click en producto abre detalle correcto")
    public void TC002_verDetalleProducto() {
        String expectedName = "Sauce Labs Backpack";
        ItemDetailPage detail = inventoryPage.clickItemByName(expectedName);

        Assert.assertEquals(detail.getItemName(), expectedName);
        Assert.assertFalse(detail.getItemDescription().isEmpty());
        Assert.assertFalse(detail.getItemPrice().isEmpty());
    }

    @Test(description = "SHOP-203 | Volver desde detalle al catalogo")
    public void TC002_volverDesdeDetalle() {
        ItemDetailPage detail = inventoryPage.clickItemByName("Sauce Labs Backpack");
        InventoryPage back = detail.goBack();
        Assert.assertTrue(back.isPageLoaded());
    }
}
