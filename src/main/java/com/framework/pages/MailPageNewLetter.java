package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


/**
 * Created by User on 08.08.2016.
 */
public class MailPageNewLetter extends Page {

    public MailPageNewLetter(WebDriver driver) {
        super(driver);
    }


    By toTxtBx = By.xpath("//textarea[@name='to']");
    By topicTxtBx = By.xpath("//input[@name='subjectbox']");
    By attachedFileBtn = By.xpath("//div[@command='Files']/div[@class='J-J5-Ji J-Z-I-Kv-H']/div[@class='J-J5-Ji J-Z-I-J6-H']");
    By sendBtn = By.xpath("//td[@class='gU Up']/div[@class='J-J5-Ji']/div[contains(@class,'aoO')][@role='button']");
    By progressbar = By.xpath("//div[contains(@role,'progressbar')]");
    By activeAttachedFileBtn = By.xpath("//div[@class='wG J-Z-I e9']");


    public void fillTitleAndAddress(String title, String address){
        typeText(toTxtBx, address, TIMEOUT);
        typeText(topicTxtBx,title);
    }

    public void completeLetter(String title, String address, String filePath ) throws InterruptedException, AWTException {
        fillTitleAndAddress(title, address);
        attachedFile(filePath);
        Thread.sleep(4000); /// cannot (don`t  have time) catch nasty pop-up "saving....." which very quickly disappearing
        clickBtnAfterLoad(progressbar, sendBtn, LONGEST_TIMEOUT);
    }

    public void attachedFile(String filePath) throws AWTException, InterruptedException {
        clickBtn(attachedFileBtn);
        waitUntilInvisible(activeAttachedFileBtn,TIMEOUT);
        chooseFile(filePath);

    }
    public void chooseFile( String filePath) throws InterruptedException, AWTException {
            setClipboardData(filePath);
            addFile();

    }

    public void setClipboardData(String string) throws InterruptedException {
        Thread.sleep(2000); /// cannot (don`t  have time) catch nasty pop-up which very quickly disappearing
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void addFile() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
