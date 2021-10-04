package com.techproed.Practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Pr01 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Ignore
    @Test
    public void testlater(){

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement emailbox = driver.findElement(By.id("session_email"));
        emailbox.sendKeys("testtechproed@gmail.com");

        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='commit']")).click();

        String userId = driver.findElement(By.className("navbar-text")).getText();
        System.out.println(userId);

        String expectedUserId = "testtechproed@gmail.com";
        Assert.assertEquals(expectedUserId,userId);

        WebElement address = driver.findElement(By.linkText("Addresses"));
        Assert.assertTrue(address.isDisplayed());

        WebElement signout = driver.findElement(By.partialLinkText("ign ou"));
        System.out.println(signout.getText());
        Assert.assertTrue(signout.isDisplayed());

        List<WebElement> alllinks = driver.findElements(By.tagName("a"));
        int linksize = alllinks.size();
        System.out.println("size: " + linksize);

        driver.findElement(By.linkText("Sign out")).click();

        boolean isLogg = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLogg);


    }

    @After
    public void tearDown(){
      //  driver.close();
    }

}
