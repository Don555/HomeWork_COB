package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by User on 09.08.2016.
 */
public class MailPageReceivedLetter extends Page {
    public MailPageReceivedLetter(WebDriver driver) {
        super(driver);
    }

    public String getTextFromAttachedFile(String fileName){
        openAttachedFile(fileName);
        return getFileText(fileName);
    }


    public void openAttachedFile(String fileName){
        clickBtn(generateXpathForAttach(fileName),TIMEOUT);
    }

    public String getFileText(String fileName){
        WebElement document = getWhenVisible(generateXpathForDoc(fileName), TIMEOUT);
        return document.getText();

    }

    public By generateXpathForDoc(String document){
        return By.xpath("//div[@role='document'][contains(@aria-label,'"+document+"')]/pre");
    }

    public By generateXpathForAttach(String document){
        return By.xpath("//span[contains(@download_url,'"+document+"')]");
    }


}
