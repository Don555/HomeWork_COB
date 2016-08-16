package com.framework.page;

import com.framework.checker.Operations;
import com.framework.page.elements.CalculatorOperator;
import com.framework.page.elements.GoBtn;
import com.framework.page.elements.input.FirstNumberInput;
import com.framework.page.elements.input.SecondNumberInput;
import com.framework.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculatorPage {
    private static final By LOAD_LOCATOR = By.xpath("//form/h2[contains(@class,'binding')]");

    private CalculatorOperator calculatorOperator;
    private FirstNumberInput firstNumberInput;
    private SecondNumberInput secondNumberInput;
    private GoBtn goBtn;
    private WebDriver driver;

	public CalculatorPage(WebDriver webDriver) {
		this.driver = webDriver;
        this.calculatorOperator = new CalculatorOperator(driver);
        this.firstNumberInput = new FirstNumberInput(driver);
        this.secondNumberInput = new SecondNumberInput(driver);
        this.goBtn = new GoBtn(driver);
	}


    private boolean waitForResult(int timeout, String res){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(LOAD_LOCATOR, res));
    }

    private CalculatorPage setData(String firstNum, String secondNum, Operations value){
        firstNumberInput.typeText(firstNum);
        secondNumberInput.typeText(secondNum);
        calculatorOperator.setOperator(value);
        return this;
    }

    private CalculatorPage runCalculator(int timeout, String res){
        goBtn.clickBtn();
        waitForResult(timeout, res);
        return this;
    }

    ///FluentInterface just as an example, can be improve or reduce in this particular case
    public void setDataAndRun(String firstNum, String secondNum, Operations value, String res){
                setData(firstNum,  secondNum, value).
                runCalculator(Helper.TIMEOUT, res);
    }

}
