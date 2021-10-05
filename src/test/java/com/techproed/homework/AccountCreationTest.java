package com.techproed.homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccountCreationTest {

    WebDriver driver;
    Faker faker = new Faker();

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        //2. Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");

        //3. Click on sign in link
        driver.findElement(By.linkText("Sign in")).click();

        //4.Send your email and click on create an account button
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        //5.Verify the Text : CREATE AN ACCOUNT
        String actualText = driver.findElement(By.xpath("//h1[.='Create an account']")).getText();
        String expectedText = "CREATE AN ACCOUNT";
        Assert.assertEquals(expectedText,actualText);

        //6. Verify the Text : YOUR PERSONAL INFORMATION
        String actualText1 = driver.findElement(By.xpath("//h3[.='Your personal information']")).getText();
        Assert.assertTrue(actualText1.contains("YOUR PERSONAL INFORMATION"));

        //7. Verify the Text : Title
        String actualText2 = driver.findElement(By.xpath("//label[.='Title']")).getText();
        Assert.assertTrue(actualText2.contains("Title"));


        //8. Select your title
        WebElement titleOption = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        if(!titleOption.isSelected()){
            titleOption.click();
        }

        //9. Enter your first name
        String fname = faker.name().firstName();
        driver.findElement(By.id("customer_firstname")).sendKeys(fname);

        //10. Enter your last name
        String lName = faker.name().lastName();
        driver.findElement(By.id("customer_lastname")).sendKeys(lName);

        //11. Enter your email
        //don't need it:)

        //12. Enter your password
        String password = faker.internet().password(6,12);
        driver.findElement(By.id("passwd")).sendKeys(password);

        //13. ENTER DATE OF BIRTH
        WebElement day=driver.findElement(By.id("days"));
        Select selectdays = new Select(day);
        selectdays.selectByValue("21");

        WebElement monthx = driver.findElement(By.id("months"));
        Select selectmonths =new Select(monthx);
        selectmonths.selectByIndex(4);//Note: selectByVisible doesn't work.why?

        WebElement year = driver.findElement(By.id("years"));
        Select years = new Select(year);
        years.selectByValue("1991");

        //14. Click on Sign up for our newsletter!
        WebElement clickOnSing = driver.findElement(By.id("newsletter"));
        if (!clickOnSing.isSelected()){
            clickOnSing.click();
        }

        //15. Enter your first name
        driver.findElement(By.id("firstname")).sendKeys(fname);

        //16. Enter your last name
        driver.findElement(By.id("lastname")).sendKeys(lName);

        //17. Enter your company
        driver.findElement(By.id("company")).sendKeys("Emrah Holding");

        //18. Enter your Address
        String address = faker.address().streetAddress();
        driver.findElement(By.id("address1")).sendKeys(address);

        //19. Enter your City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        //20. SELECT STATE
        WebElement statedropdown = driver.findElement(By.id("id_state"));
        Select selectState = new Select(statedropdown);
        selectState.selectByVisibleText("Colorado");

        //21. Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys("80221");

        //22.SELECT COUNTRY
        WebElement countrydropdown = driver.findElement(By.id("id_country"));
        Select selectcountry = new Select(countrydropdown);
        selectcountry.selectByVisibleText("United States");


        //23. Enter additional information
        driver.findElement(By.id("other")).sendKeys("Hello World again");

        //24. Enter home phone
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());

        //25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());

        //26. Enter reference name
        WebElement referanceTextBox = driver.findElement(By.id("alias"));
        referanceTextBox.clear();
        referanceTextBox.sendKeys(faker.name().fullName());

        //27. Click Register
        driver.findElement(By.id("submitAccount")).click();

        //20. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
        //1.Result: Displayed -->>> Resource Limit Is Reached (The website is temporarily unable to service your request as it exceeded resource limit. Please try again later.)
        String verifyText = driver.findElement(By.xpath("//h1[.='My account']")).getText();
        Assert.assertTrue(verifyText.contains("MY ACCOUNT"));

    }
    @After
    public void tearDown(){
        driver.close();
    }


}
