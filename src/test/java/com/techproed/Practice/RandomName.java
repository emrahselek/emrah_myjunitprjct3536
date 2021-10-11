package com.techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RandomName {

    ArrayList<String> list = new ArrayList<>();
    WebDriver driver;

    @Before
    public void Url(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Run() throws InterruptedException {
        driver.get("https://wheelofnames.com/");

        WebElement element = driver.findElement(By.xpath("//div[@id='entries']"));
        element.clear();
        element.sendKeys("NURAY\n ORCUN\n ESRA\n EMRAH\n ESEN\n ABDURRAHMAN\n ADIL\n FURKAN" );
        Thread.sleep(5000);

        driver.findElement(By.id("bottomInstruction")).click();

        for(int i = 0; i<7;i++) {
            Thread.sleep(12000);
            list.add( element.findElement(By.xpath("//*[@id='app']/span/div[7]/div[2]/div/section/h1/span")).getText());//listeye eklemek icin
            driver.findElement(By.xpath("//button[@class='button is-medium is-info']")).sendKeys(Keys.ENTER);//remove
            Thread.sleep(5000);
            driver.findElement(By.id("wheelCanvas")).click();//carki cevirmek icin
        }

        list.add(element.findElement(By.xpath("//div[@id='entries']")).getText());//en son kalani listeden direk aliyoruz.

        System.out.println(list);//[ ESEN,  ESRA,  EMRAH, NURAY,  ORCUN,  ADIL,  FURKAN,  ABDURRAHMAN]

        driver.close();

    }
}