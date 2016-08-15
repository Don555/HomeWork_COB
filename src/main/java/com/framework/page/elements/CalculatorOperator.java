package com.framework.page.elements;

import com.framework.checker.Operations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorOperator  {

    private static final By LOCATOR = By.xpath("//select[@ng-model='operator'][contains(@class,'span1')]");

    private Select dropdown;

    public CalculatorOperator(WebDriver webDriver) {
        this.dropdown  = new Select(webDriver.findElement(LOCATOR));
    }

    public void setOperator(Operations value){
        dropdown.selectByValue(value.toString());
    }


}
