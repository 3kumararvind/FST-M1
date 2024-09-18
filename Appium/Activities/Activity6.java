package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void sendingMessageTest(){
        driver.get("https://v1.training-support.net/selenium/lazy-loading");

        String scroll = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageCount1 = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Count of Images before scroll:" + imageCount1.size());

        driver.findElement(AppiumBy.androidUIAutomator(scroll + ".scrollTextIntoView(\"helen\")"));
        List<WebElement> imageCount2 = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Count of Images before scroll:" + imageCount2.size());
        Assert.assertEquals(imageCount2.size(), 3);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        }
    }

