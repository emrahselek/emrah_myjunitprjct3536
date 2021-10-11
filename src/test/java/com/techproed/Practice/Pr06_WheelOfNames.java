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

public class Pr06_WheelOfNames {

    WebDriver driver;

    @Before
    public void settup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://wheelofnames.com/");
        WebElement nameOfBox = driver.findElement(By.id("entries"));
        nameOfBox.clear();
        nameOfBox.sendKeys("NURAY\n ORCUN\n ESRA\n EMRAH\n ESEN\n ABDURRAHMAN\n ADIL\n FURKAN" );
        Thread.sleep(5000);

        driver.findElement(By.id("bottomInstruction")).click();
        Thread.sleep(15000);



        driver.findElement(By.xpath("//button[@class='button is-medium is-info']")).click();
        Thread.sleep(3000);

        WebElement clickToSpin2 = driver.findElement(By.id("wheelCanvas"));
        clickToSpin2.click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//button[@class='button is-medium is-info']")).click();
        Thread.sleep(3000);


        clickToSpin2.click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//button[@class='button is-medium is-info']")).click();
        Thread.sleep(3000);





    }
}
