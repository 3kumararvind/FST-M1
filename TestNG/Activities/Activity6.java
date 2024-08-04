package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username", "password"})
    public void logTest(String username, String password){
        driver.findElement(By.id("username"));
        driver.findElement(By.id("password"));

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(message, "Welcome Back, admin");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
