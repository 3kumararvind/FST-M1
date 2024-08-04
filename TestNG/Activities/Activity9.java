package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser");


    }
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }
    @Test(priority = 0)
    public void simpleAlertTestCase(){
        Reporter.log("In simple alert test");
        driver.findElement(By.id("simple")).click();
        Alert a = driver.switchTo().alert();
        String alertText = a.getText();
        Reporter.log("Alert Text is: " + alertText);
        Assert.assertEquals("This is a JavaScript Alert!", alertText);
        a.accept();
        Reporter.log("Simple alert test ended");

    }
    @Test(priority = 1)
    public void confirmAlertTestCase(){
        Reporter.log("In confirm alert test");
        driver.findElement(By.id("confirm")).click();
        Alert a = driver.switchTo().alert();
        String alertText = a.getText();
        Reporter.log("Alert Text is: " + alertText);

        Assert.assertEquals( alertText, "This is a JavaScript Confirmation!");
        a.accept();
        Reporter.log("Confirm alert test ended");

    }
    @Test(priority = 2)
    public void promptAlertTestCase(){
        Reporter.log("In prompt alert test");
        driver.findElement(By.id("prompt")).click();
        Alert a = driver.switchTo().alert();
        String alertText = a.getText();
        Reporter.log("Alert Text is: " + alertText);
        a.sendKeys("Awesome!");
        Assert.assertEquals( alertText, "This is a JavaScript Prompt!");
        a.accept();
        Reporter.log("Prompt alert test ended");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
