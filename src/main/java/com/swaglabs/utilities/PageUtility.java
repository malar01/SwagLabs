package com.swaglabs.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtility{

    public void enterText(WebElement element,String text){
        element.sendKeys(text);
    }
    public void clickOnElement(WebElement element){
        element.click();
    }

    public String getText(WebElement element){
        String title= element.getText();
        return title;
    }
}
