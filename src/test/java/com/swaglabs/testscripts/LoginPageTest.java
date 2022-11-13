package com.swaglabs.testscripts;

import com.swaglabs.automation.Base;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import com.swaglabs.pages.YourCartPage;
import com.swaglabs.utilities.ExcelUtility;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {

    LoginPage loginPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    ExcelUtility excel;

    @Test(priority = 1,description = "TC_01_Verify user login with valid data")
    public void verifyUserLoginWithValidData() throws IOException {
        loginPage = new LoginPage(driver);
       excel=new ExcelUtility();
        String name=excel.readSingleData(1,0,"LoginPage");
        loginPage.enterUserName(name);
        String pass=excel.readSingleData(1,1,"LoginPage");
        loginPage.enterPassword(pass);
        productPage=loginPage.clickLoginButton();
        String expected_text=excel.readSingleData(1,0,"Product-page-text");
        String actual_text=productPage.getProductPageText();
        Assert.assertEquals(actual_text,expected_text,"ERROR : text does not match");
    }

    @Test(priority = 2,description = "TC_002_Verify user able to select 3 items randomly")
    public void verifySelectRandomItems(){
       loginPage = new LoginPage(driver);
        productPage=new ProductPage(driver);
        yourCartPage=new YourCartPage(driver);
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
        String expected_result= excel.readSingleData(1,0,"Your-cart-text");
        String actual_result=yourCartPage.getYourCartText();
        Assert.assertEquals(actual_result,expected_result,"ERROR : text does not match");
    }
}
