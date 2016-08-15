package com.framework.page.elements.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.AssertJUnit.assertTrue;


public class HistoryTable extends LoadableComponent<HistoryTable > {

    private WebDriver driver;
    WebElement element;
    private static final By LOCATOR = By.xpath("//table[@class='table']/tbody");


    public HistoryTable(WebDriver webDriver) {
        this.driver = webDriver;
        this.element = driver.findElement(LOCATOR);
    }

    public String getValue(int rowsNum, int colsNum){
        return new TableRow(this, rowsNum).getValue(colsNum);
    }


    @Override
    public void load() {
        element = driver.findElement(LOCATOR);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(element.equals(driver.findElement(LOCATOR)));
    }
}
