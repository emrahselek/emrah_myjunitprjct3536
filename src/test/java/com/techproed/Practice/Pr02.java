package com.techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Pr02 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void tes(){
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']"))
                .sendKeys("emrah selek" + Keys.ENTER);

        String result = driver.findElement(By.xpath("//div[@id='result-stats']"))
                .getText().substring(6,14);
        System.out.println(result);

driver.close();


    }


}
