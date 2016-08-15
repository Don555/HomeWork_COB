package com.framework.page.elements.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


class RowValue {
    private WebElement webElement;

    RowValue(TableRow row, int ColNum) {
        this.webElement = row.element.findElement(By.xpath("td["+ColNum+"]"));
    }

    String getValue(){
       return webElement.getText();
    }

}
