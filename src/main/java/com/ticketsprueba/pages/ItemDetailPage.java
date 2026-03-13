package com.ticketsprueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailPage extends BasePage {

    @FindBy(className = "inventory_details_name")
    private WebElement itemName;

    @FindBy(className = "inventory_details_desc")
    private WebElement itemDescription;

    @FindBy(className = "inventory_details_price")
    private WebElement itemPrice;

    @FindBy(id = "back-to-products")
    private WebElement backBtn;

    @FindBy(css = "button[id^='add-to-cart']")
    private WebElement addToCartBtn;

    @FindBy(css = "button[id^='remove']")
    private WebElement removeBtn;

    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return getText(itemName);
    }

    public String getItemDescription() {
        return getText(itemDescription);
    }

    public String getItemPrice() {
        return getText(itemPrice);
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    public void removeFromCart() {
        click(removeBtn);
    }

    public InventoryPage goBack() {
        click(backBtn);
        return new InventoryPage(driver);
    }
}
