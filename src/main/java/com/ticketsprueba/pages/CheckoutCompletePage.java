package com.ticketsprueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement successHeader;

    @FindBy(className = "complete-text")
    private WebElement successText;

    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessHeader() {
        return getText(successHeader);
    }

    public String getSuccessText() {
        return getText(successText);
    }

    public boolean isOrderComplete() {
        return isDisplayed(successHeader);
    }

    public InventoryPage backToHome() {
        click(backHomeBtn);
        return new InventoryPage(driver);
    }
}
