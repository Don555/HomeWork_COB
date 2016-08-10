package com.framework.flow;

import com.framework.pages.LoginPage;
import com.framework.pages.MailPage;
import com.framework.pages.MailPageReceivedLetter;
import com.framework.util.PropertyLoader;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;

import static com.framework.util.PropertyLoader.PROP_FILE;
import static com.framework.util.PropertyLoader.TEST_DATA;

/**
 * Created by User on 09.08.2016.
 */
public class ActionsFlow {
    LoginPage loginPage;
    MailPage mailPage;
    MailPageReceivedLetter mailPageReceivedLetter;
    WebDriver driver;

    public ActionsFlow(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void LoginAndSendLetter() throws InterruptedException, AWTException {
        File attachedFile = new File(PropertyLoader.loadProperty("test1.filePath", TEST_DATA));

        mailPage = new LoginPage(driver).loginToGmail(PropertyLoader.loadProperty("user1.username", PROP_FILE), PropertyLoader.loadProperty("user1.password", PROP_FILE));
        mailPage.writeLetter(PropertyLoader.loadProperty("test1.mailTitle",TEST_DATA),PropertyLoader.loadProperty("test1.mailAddress",TEST_DATA), attachedFile.getAbsolutePath()) ;
    }
    public void ChangeUser() {
        loginPage = mailPage.switchToNewSession();
        mailPage = loginPage.loginToGmail(PropertyLoader.loadProperty("user2.username", PROP_FILE), PropertyLoader.loadProperty("user2.password", PROP_FILE));

    }
    public String openLetterAndGetAttachedText(){
        mailPageReceivedLetter = mailPage.openLetterByTitle(PropertyLoader.loadProperty("test1.mailTitle",TEST_DATA));
        return mailPageReceivedLetter.getTextFromAttachedFile(PropertyLoader.loadProperty("test1.fileName",TEST_DATA));
    }
}
