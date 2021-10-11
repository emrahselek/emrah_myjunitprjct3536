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

public class Pr07_wheel {

ArrayList<String> list = new ArrayList<>();
WebDriver driver;

@Before
public void Url(){
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
}

@Test
public void Run() throws InterruptedException {
driver.get("https://wheelofnames.com/");

WebElement element =  driver.findElement(By.xpath("//div[@id='entries']"));
element.clear();

element.sendKeys("NURAY\n ORCUN\n ESRA\n EMRAH\n ESEN\n ABDURRAHMAN\n ADIL\n FURKAN" );

driver.findElement(By.id("topInstruction")).click();

for(int i = 0; i<3;i++) {
    Thread.sleep(11000);
    list.add( element.findElement(By.xpath("//*[@id='app']/span/div[7]/div[2]/div/section/h1/span")).getText());
    driver.findElement(By.xpath("//button[@class='button is-medium is-info']")).sendKeys(Keys.RETURN);
    Thread.sleep(5000);
    driver.findElement(By.id("wheelCanvas")).click();

}
list.add(element.findElement(By.xpath("//div[@id='entries']")).getText());
System.out.println(list);
driver.close();


}

}
