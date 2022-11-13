package com.swaglabs.testscripts;

import com.swaglabs.automation.Base;
import com.swaglabs.pages.*;
import com.swaglabs.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {

    LoginPage loginPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    ExcelUtility excel;

    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;

    CheckoutCompletePage checkoutCompletePage;

    @Test(priority = 1,description = "TC_001_Verify user able to select, add and purchase random items")
    public void verifyUserAbleToSelectAddPurchaseRandomItems(){
        loginPage = new LoginPage(driver);
        productPage=new ProductPage(driver);
        yourCartPage=new YourCartPage(driver);
        checkoutInfoPage=new CheckoutInfoPage(driver);
        checkoutCompletePage=new CheckoutCompletePage(driver);
        excel=new ExcelUtility();
        String name=excel.readSingleData(1,0,"LoginPage");
        loginPage.enterUserName(name);
        String pass=excel.readSingleData(1,1,"LoginPage");
        loginPage.enterPassword(pass);
        productPage=loginPage.clickLoginButton();
        productPage.clickToAddProductBackpack();
        productPage.clickToAddProductBikeLight();
        productPage.clickToAddProductFleeceJacket();
        yourCartPage=productPage.clickAddToCart();
        checkoutInfoPage=yourCartPage.clickOnCheckout();
        String firstName=excel.readSingleData(1,0,"Checkout_info");
        checkoutInfoPage.enterFirstName(firstName);
        String lastName=excel.readSingleData(1,1,"Checkout_info");
        checkoutInfoPage.enterLastName(lastName);
        String zipCode=excel.readSingleData(1,2,"Checkout_info");
        checkoutInfoPage.enterZipCode(zipCode);
        checkoutOverviewPage=checkoutInfoPage.clickOnContinueButton();
        checkoutCompletePage=checkoutOverviewPage.clickFinishButton();
        String expected_result= excel.readSingleData(1,0,"Checkout_complete");
        String actual_result=checkoutCompletePage.getOrderCompleteStatus();
        System.out.println(actual_result);
        Assert.assertEquals(actual_result,expected_result,"ERROR : text does not match");
    }

    @Test(priority = 2,description = "TC_02_Verify user login with invalid user credentials")
    public void verifyUserLoginWithInvalidUserCredentials(){
        loginPage = new LoginPage(driver);
        excel=new ExcelUtility();
        String name=excel.readSingleData(1,0,"Invalid_credentials");
        loginPage.enterUserName(name);
        String pass=excel.readSingleData(1,1,"Invalid_credentials");
        loginPage.enterPassword(pass);
        productPage=loginPage.clickLoginButton();
        String expected_text=excel.readSingleData(1,0,"Validation_Message");
        String actual_text=loginPage.getLockedOutMessage();
        System.out.println(actual_text);
        Assert.assertEquals(actual_text,expected_text,"ERROR : No validation message displayed after unsuccessful login");
    }
}
