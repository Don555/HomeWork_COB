package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Created by User on 07.08.2016.
 */
public class MailPage extends Page {

    public MailPage(WebDriver driver) {
        super(driver);
    }



    By createBtn = By.xpath("//div[@class='z0']/div[contains(@class,'T-I J-J5-Ji T-I-KE L3')][@role='button']");
    By accountBtn = By.xpath("//a[contains(@href, 'https://accounts.google.com/SignOutOptions')][@role='button']");
    By addSessionBtn = By.xpath("//a[contains(@href, 'https://accounts.google.com/AddSession')]");

    public MailPageNewLetter openNewLetter(){
        clickBtn(createBtn, LONG_TIMEOUT);
        return new MailPageNewLetter(driver);
    }

    public void writeLetter(String title, String mail, String filePath) throws AWTException, InterruptedException {
        openNewLetter().completeLetter(title, mail, filePath);
    }

    public LoginPage switchToNewSession(){
        addNewSession();
        switchToSecondTab();
        return new LoginPage(driver);
    }

    public void addNewSession(){
        clickBtn(accountBtn, TIMEOUT);
        clickBtn(addSessionBtn);
    }

    public  MailPageReceivedLetter openLetterByTitle(String title){
        getWhenClickable(generateXpathByLetterTitle(title), TIMEOUT).click();
        return new MailPageReceivedLetter(driver);
    }

    public By generateXpathByLetterTitle( String title){
        return By.xpath("//span/b[contains(.,'"+title+"')]/ancestor::div[contains(@role,'link')]");

    }


}