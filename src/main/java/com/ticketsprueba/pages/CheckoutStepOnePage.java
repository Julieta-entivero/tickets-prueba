package com.ticketsprueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMsg;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String firstName, String lastName, String zip) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(zipInput, zip);
    }

    public CheckoutStepTwoPage continueToStepTwo() {
        click(continueBtn);
        return new CheckoutStepTwoPage(driver);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public CartPage cancel() {
        click(cancelBtn);
        return new CartPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }
}
