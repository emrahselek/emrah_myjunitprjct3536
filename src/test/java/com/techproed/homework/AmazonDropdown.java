package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonDropdown extends TestBase {

    @Test
    public void dropDownTest() {
        driver.get("https://www.amazon.com");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        String firstSelectOption = select.getFirstSelectedOption().getText();
        System.out.println(firstSelectOption);
        Assert.assertEquals("All Departments", firstSelectOption);

        select.selectByIndex(3);
        String _4choose = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Amazon Devices", _4choose);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions) {
            System.out.println(eachOption.getText());
        }
        System.out.println("total number of all options: " + allOptions.size());

        select.selectByVisibleText("Appliances");
        String isExist = select.getFirstSelectedOption().getText();
        Assert.assertTrue(isExist.contains("Appliances"));

        if (isExist.contains("Appliances")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}

