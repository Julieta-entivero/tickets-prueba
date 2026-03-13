package com.ticketsprueba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        try {
            return getText(pageTitle).equals("Products");
        } catch (Exception e) {
            return false;
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public void addItemToCartByName(String name) {
        for (WebElement item : items) {
            String itemName = item.findElement(By.className("inventory_item_name")).getText();
            if (itemName.equals(name)) {
                item.findElement(By.cssSelector("button[id^='add-to-cart']")).click();
                return;
            }
        }
    }

    public void removeItemByName(String name) {
        for (WebElement item : items) {
            String itemName = item.findElement(By.className("inventory_item_name")).getText();
            if (itemName.equals(name)) {
                item.findElement(By.cssSelector("button[id^='remove']")).click();
                return;
            }
        }
    }

    public String getCartCount() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public CartPage goToCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    public void sortBy(String visibleText) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(visibleText);
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (WebElement item : items) {
            names.add(item.findElement(By.className("inventory_item_name")).getText());
        }
        return names;
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement item : items) {
            String raw = item.findElement(By.className("inventory_item_price")).getText();
            prices.add(Double.parseDouble(raw.replace("$", "")));
        }
        return prices;
    }

    public double getItemPriceByName(String name) {
        for (WebElement item : items) {
            String itemName = item.findElement(By.className("inventory_item_name")).getText();
            if (itemName.equals(name)) {
                String raw = item.findElement(By.className("inventory_item_price")).getText();
                return Double.parseDouble(raw.replace("$", ""));
            }
        }
        return -1;
    }

    public ItemDetailPage clickItemByName(String name) {
        for (WebElement item : items) {
            WebElement nameEl = item.findElement(By.className("inventory_item_name"));
            if (nameEl.getText().equals(name)) {
                nameEl.click();
                return new ItemDetailPage(driver);
            }
        }
        return null;
    }

    public void logout() {
        click(menuBtn);
        click(logoutLink);
    }
}
