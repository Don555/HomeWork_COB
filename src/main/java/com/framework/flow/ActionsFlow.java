package com.framework.flow;

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

    WebDriver driver;

    public ActionsFlow(WebDriver webDriver) {
        this.driver = webDriver;
    }


}
