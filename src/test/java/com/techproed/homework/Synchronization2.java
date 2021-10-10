package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization2 extends TestBase {

    @Test
    public void isEnabled(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver,8);
        WebElement enabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        Assert.assertTrue(enabledText.getText().equals("It's enabled!"));

        //And verify the textbox is enabled (I can type in the box)
        WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        Assert.assertTrue(textbox.isEnabled());

        //And click on Disable button
        driver.findElement(By.xpath("//*[.='Disable']")).click();

        //And verify the message is equal to “It's disabled!”
        WebElement disabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        Assert.assertTrue(disabledText.getText().equals("It's disabled!"));

        //And verify the textbox is disabled (I cannot type in the box)
        Assert.assertFalse(textbox.isEnabled());

    }
}
