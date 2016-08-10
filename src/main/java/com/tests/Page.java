package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page {

    public static final int LONGEST_TIMEOUT = 90;
    public static final int LONG_TIMEOUT = 60;
    public static final int TIMEOUT = 30;


	protected WebDriver driver;
	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver webDriver) {
		this.driver = webDriver;
	}


	public Page clickBtn (By locator){
        driver.findElement(locator).click();
        return this;
	}
    public Page clickBtn (By locator, int timeout){
        getWhenClickable(locator, timeout).click();
        return this;
    }
    public Page clickBtnAfterLoad (By LoadLocator, By locator, int timeout){
        waitUntilInvisible(LoadLocator, timeout);
        clickBtn(locator);
        return this;
    }

	public Page typeText (By locator, String text){
		driver.findElement(locator).sendKeys(text);
		return this;
	}
    public Page typeText (By locator, String text, int timeout){
        getWhenVisible(locator, timeout).sendKeys(text);
        return this;
    }

	public WebElement getWhenVisible(By locator, int timeout){
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getWhenClickable(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean waitUntilInvisible(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void switchToSecondTab() throws NoSuchWindowException {
        waitForTwoTabsOpen();
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }

    public boolean waitForTwoTabsOpen(){
        WebDriverWait wait = new WebDriverWait(driver, LONG_TIMEOUT);
        return  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
