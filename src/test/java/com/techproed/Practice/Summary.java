package com.techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Summary {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void locators() {
        driver.get("http://a.testaddressbook.com/sign_in");
//        driver
//                .findElement(By.id("session_email"))//Locating the element by id
//                .sendKeys("testtechproed@gmail.com");//typing in the element

        //OR RETURN TYPE OF findElement is WebElement
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        //Password Element:
        driver.findElement(By.name("session[password]")).sendKeys("Test1234!");
        //Locating sign in button and click on it
        driver.findElement(By.name("commit")).click();


//      Then verify that the expected user id:
        String userIdText = driver.findElement(By.className("navbar-text")).getText();
        String expectedUserId="testtechproed@gmail.com";
        Assert.assertEquals(expectedUserId,userIdText);
        Assert.assertEquals("java", "java"); //pass

        //Verify the Addresses and Sign Out texts are displayed
        WebElement addressesElement=driver.findElement(By.linkText("Addresses"));
        Assert.assertTrue(addressesElement.isDisplayed());
        WebElement signOutElement=driver.findElement(By.partialLinkText("ign out"));//Will find Sign out
        Assert.assertTrue(signOutElement.isDisplayed());


        //Find the number of total link on the page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int linkSize=allLinks.size();
        System.out.println("Number of the link is " + linkSize);

        //Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

        //Verify the sign out is successful
        boolean isLoggedOut = driver
                .getCurrentUrl()
                .equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLoggedOut);

    }

        @After
        public void tearDown () {
//        driver.close();
        }



    }


