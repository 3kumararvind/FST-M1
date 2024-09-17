package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4{
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void contactTest(){

        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Add\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Name\"]")).sendKeys("Arvind IBM");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys("9875432190");
        driver.findElement(AppiumBy.id("android:id/button2")).click();

        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.android.contacts:id/custom_title\"]")).getText();
        Assert.assertEquals(contactName, "Arvind IBM");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    }

