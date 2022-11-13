package com.swaglabs.pages;

import com.swaglabs.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends ObjectUtility {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='login-button']")
    WebElement login_button;

    public void enterUserName(String name) {
        wait.waitUntilVisibilityOfElement(10,driver,username);
        page.enterText(username, name);
    }

    public void enterPassword(String pass) {
        wait.waitUntilVisibilityOfElement(10,driver,password);
        page.enterText(password, pass);
    }
    public ProductPage clickLoginButton(){
        page.clickOnElement(login_button);
        return new ProductPage(driver);
    }


}
