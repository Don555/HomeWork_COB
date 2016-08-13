package com.tests;

import com.framework.flow.ActionsFlow;
import com.framework.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.framework.util.PropertyLoader.PROP_FILE;
import static com.framework.util.PropertyLoader.TEST_DATA;

public class Tests {

    WebDriver driver;

	@BeforeTest
	public void setup(){
		final File file = new File(PropertyLoader.loadProperty("path.webDriver", PROP_FILE));
		System.setProperty(PropertyLoader.loadProperty("webDriver", PROP_FILE), file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to(PropertyLoader.loadProperty("url", PROP_FILE));
		driver.manage().window().maximize();
	}


	@Test
	public void sendFileTest() throws InterruptedException, AWTException {

		Assert.assertTrue(true);

	}

	@AfterTest
	public void end(){
		driver.close();
	}


}
