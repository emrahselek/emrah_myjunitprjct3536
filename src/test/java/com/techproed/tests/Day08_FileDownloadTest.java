package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest(){
//        Create a class:FileDownloadTest
//        fileDownloadTest()
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download flower.png file
        driver.findElement(By.linkText("flower.jpeg")).click();

//        Then verify if the file downloaded successfully

//      Tomorrow we will continue.
        String homepath = System.getProperty("user.home");
        String downloadpath = homepath+"\\Downloads\\flower.jpeg";
        System.out.println(downloadpath);
        boolean isExist = Files.exists(Paths.get(downloadpath));
        Assert.assertTrue(isExist);

    }
}