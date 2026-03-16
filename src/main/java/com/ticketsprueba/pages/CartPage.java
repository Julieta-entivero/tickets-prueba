package com.ticketsprueba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public String getItemName(int index) {
        return cartItems.get(index).findElement(By.className("inventory_item_name")).getText();
    }

    public String getItemPrice(int index) {
        return cartItems.get(index).findElement(By.className("inventory_item_price")).getText();
    }

    public void removeItem(int index) {
        cartItems.get(index).findElement(By.cssSelector("button[id^='remove']")).click();
    }

    public void removeItemByName(String name) {
        for (WebElement item : cartItems) {
            if (item.findElement(By.className("inventory_item_name")).getText().equals(name)) {
                item.findElement(By.cssSelector("button[id^='remove']")).click();
                return;
            }
        }
    }

    public CheckoutStepOnePage checkout() {
        click(checkoutBtn);
        return new CheckoutStepOnePage(driver);
    }

    public InventoryPage continueShopping() {
        click(continueShoppingBtn);
        return new InventoryPage(driver);
    }
}
