package com.swaglabs.pages;

import com.swaglabs.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ObjectUtility {

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Products']")
    WebElement products_page_text;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement add_product_backpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement add_product_bike_light;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement add_product_fleece_jacket;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement add_to_cart;


    public String getProductPageText() {
        String title = page.getText(products_page_text);
        return title;
    }

    public void clickToAddProductBackpack() {
        page.clickOnElement(add_product_backpack);
    }

    public void clickToAddProductBikeLight() {
        page.clickOnElement(add_product_bike_light);
    }

    public void clickToAddProductFleeceJacket() {
        page.clickOnElement(add_product_fleece_jacket);
    }

    public YourCartPage clickAddToCart() {
        page.clickOnElement(add_to_cart);
        return new YourCartPage(driver);
    }
}