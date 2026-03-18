package com.ticketsprueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage {

    @FindBy(className = "summary_subtotal_label")
    private WebElement subtotal;

    @FindBy(className = "summary_tax_label")
    private WebElement tax;

    @FindBy(className = "summary_total_label")
    private WebElement total;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getSubtotal() {
        return getText(subtotal);
    }

    public String getTax() {
        return getText(tax);
    }

    public String getTotal() {
        return getText(total);
    }

    public CheckoutCompletePage finish() {
        click(finishBtn);
        return new CheckoutCompletePage(driver);
    }

    public InventoryPage cancel() {
        click(cancelBtn);
        return new InventoryPage(driver);
    }
}
