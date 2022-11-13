package com.swaglabs.pages;

import com.swaglabs.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends ObjectUtility {
    public WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='checkout_complete_container']//h2[text()='THANK YOU FOR YOUR ORDER']")
    WebElement order_complete_status;

    public String getOrderCompleteStatus() {
        String text = page.getText(order_complete_status);
        return text;
    }
}
