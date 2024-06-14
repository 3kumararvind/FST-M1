package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");

    }
    @Test
    public void TitleTest(){
        String pageTitle = driver.getTitle();
        System.out.println("Title of page: "+pageTitle);

        Assert.assertEquals(pageTitle, "'Training Support'");

        driver.findElement(By.id("about-link")).click();

        System.out.println("About Us Title: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "About Training Support");

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
