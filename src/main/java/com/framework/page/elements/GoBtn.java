package com.framework.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoBtn  {
    private static final By LOCATOR = By.xpath("//button[@id='gobutton']");
    private WebElement element;

    public GoBtn(WebDriver webDriver) {
        this.element = webDriver.findElement(LOCATOR);    }

    public void clickBtn (){
        element.click();
    }
}
