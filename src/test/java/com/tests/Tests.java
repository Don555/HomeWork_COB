package com.tests;

import com.framework.checker.Calculator;
import com.framework.checker.Operations;
import com.framework.page.CalculatorPage;
import com.framework.page.elements.table.HistoryTable;
import com.framework.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.framework.checker.Operations.*;
import static com.framework.util.Helper.COLUMN_TO_VALIDATE;
import static com.framework.util.Helper.ROW_TO_VALIDATE;
import static com.framework.util.PropertyLoader.PROP_FILE;

public class Tests {

    private WebDriver driver;
	private CalculatorPage calculatorPage;
	private HistoryTable table;


	@BeforeTest
	public void setup(){
		final File file = new File(PropertyLoader.loadProperty("path.webDriver", PROP_FILE));
		System.setProperty(PropertyLoader.loadProperty("webDriver", PROP_FILE), file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to( PropertyLoader.loadProperty("url", PROP_FILE) );

		calculatorPage = new CalculatorPage(driver);
		table = new HistoryTable(driver);

	}



	@Test(dataProvider = "ValidDataProvider")
	public void verifyPositive(String firstNum, String secondNum, Operations value) {
		String res = Calculator.calculate(firstNum,secondNum,value);
		calculatorPage.setDataAndRun(firstNum,secondNum,value,res);
		table.load();
		Assert.assertTrue(res.equals(table.getValue(ROW_TO_VALIDATE, COLUMN_TO_VALIDATE)));


	}
	@Test(dataProvider = "NegativeDataProvider")
	public void verifyNegative(String firstNum, String secondNum, Operations value) {
		String res = Calculator.calculate(firstNum,secondNum,value);
		calculatorPage.setDataAndRun(firstNum,secondNum,value,res);
		table.load();
		Assert.assertTrue(res.equals(table.getValue(ROW_TO_VALIDATE, COLUMN_TO_VALIDATE)));


	}


	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][]{
				{ "1","2", ADDITION },
				{ "-2","4", ADDITION },
				{ "-4","-2", ADDITION },
				{ "1","2", DIVISION },
				{ "-2","4", DIVISION },
				{ "-4","-2", DIVISION },
				{ "1","2", MULTIPLICATION },
				{ "-2","4", MULTIPLICATION },
				{ "-4","-2", MULTIPLICATION },
				{ "1","2", SUBTRACTION },
				{ "-2","4", SUBTRACTION },
				{ "-4","-2", SUBTRACTION },
				{ "1","2", MODULO },
				{ "-2","4", MODULO },
				{ "-4","-2", MODULO }

		};
	}

	@DataProvider
	public Object[][] NegativeDataProvider() {
		return new Object[][]{
				{ "ww","ww", ADDITION },
				{ "","4", ADDITION },
				{ "dd","-2", ADDITION },
				{ "1","0", DIVISION },
				{ "5","-0", DIVISION },
				{ "-4","0", DIVISION },
				{ "dd","dd", MULTIPLICATION },
				{ "","", MULTIPLICATION },
				{ "hh","-2", MULTIPLICATION },
				{ "","2", SUBTRACTION },
				{ "yy","yy", SUBTRACTION },
				{ "","-hh", SUBTRACTION },
				{ "","2", MODULO },
				{ "h","4", MODULO },
				{ "hh","-", MODULO }

		};
	}

	@AfterTest
	public void end(){
		driver.close();
	}


}
