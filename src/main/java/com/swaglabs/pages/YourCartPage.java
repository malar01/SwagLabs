package com.swaglabs.pages;

import com.swaglabs.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends ObjectUtility {
    public WebDriver driver;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Your Cart']")
    WebElement your_cart;

    public String getYourCartText() {
        String text=page.getText(your_cart);
        return text;
    }
}