package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void titleTest(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Target Practice");
    }

    @Test
    public void testBlackButton(){
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");

    }

    @Test(enabled = false)
    public void skipTest(){
        String heading2= driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(heading2.contains("Practice"));
    }

    @Test
    public void skipTest2(){
        throw new SkipException("Test case skipped");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
