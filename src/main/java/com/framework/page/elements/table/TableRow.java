package com.framework.page.elements.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


class TableRow {
    WebElement element;

    TableRow(HistoryTable table, int RowNum) {
        this.element = table.element.findElement(By.xpath("tr["+RowNum+"]"));
    }

    String getValue(int ColNum ){
        return new RowValue(this, ColNum).getValue();
    }



}
