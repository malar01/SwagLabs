package com.swaglabs.pages;

import com.swaglabs.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage extends ObjectUtility {
    public WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continue_button;

    public void enterFirstName(String fname) {
        page.enterText(firstName, fname);
    }

    public void enterLastName(String lname) {
        page.enterText(lastName, lname);
    }

    public void enterZipCode(String zcode) {
        page.enterText(zipCode, zcode);
    }

    public CheckoutOverviewPage clickOnContinueButton() {
        page.clickOnElement(continue_button);
        return new CheckoutOverviewPage(driver);
    }
}