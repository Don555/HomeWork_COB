package com.framework.page.elements.input;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FirstNumberInput {
    private static final By LOCATOR = By.xpath("//input[@ng-model='first'][contains(@class,'input-small')]");
    private WebElement element;

    public FirstNumberInput(WebDriver webDriver) {
        this.element = webDriver.findElement(LOCATOR);
    }
    public void typeText ( String text){
        element.sendKeys(text);
    }


}
