package com.techproed.tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {

    @Test
    public void isExist(){
        /*
        * Selenium has limitation with desktop application
        * With Java we can check if a file exist in our local computer
        * */

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");// C:\Users\BelomeX
        System.out.println("homePath: "+homePath);

        String pathOfFLower = homePath+"\\Desktop\\flower.jpeg";
        System.out.println("pathOfFlower: "+pathOfFLower);

//        String pathOfFLower = "C:\\Users\\BelomeX\\Desktop\\flower.jpeg";//hard coded

//        WINDOW operator PATH:
//        String pathOfFLower = homePath+"\\Desktop\\flower.jpeg";

        //This code checks if pathOfFlower is exist or not.
        //If it exist, this returns true; otherwise, this returns false
        boolean isExist  = Files.exists(Paths.get(pathOfFLower));
        System.out.println(isExist);
        Assert.assertTrue(isExist);
    }
}