package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*
 * Sample page
 * 
 * @author Sebastiano Armeli-Battana
 */
public class LoginPage extends Page {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}



	By loginNameTxtbx = By.xpath("//input[@id='Email']");
	By passTxtbx = By.xpath("//input[@id='Passwd']");
	By signInBtn = By.xpath("//input[@id='signIn']");
	By nextBtn = By.xpath("//input[@id='next']");


	public MailPage loginToGmail(String login, String pass){
		setLogin(login);
		setPass(pass);
		return new MailPage(driver);
	}

	private void setLogin(String login){
		typeText(loginNameTxtbx, login);
		clickBtn(nextBtn);
	}

	private void setPass(String pass){
		typeText(passTxtbx, pass);
		clickBtn(signInBtn);
	}
}
