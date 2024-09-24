package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleKeepReminder {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void taskTest(){
        try{
            driver.findElement(AppiumBy.accessibilityId("New text note")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
            driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Mega Book Fair");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
            driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Organized By Alchemy");
            driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
            driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.google.android.keep:id/browse_note_interior_content\"])")));
            String title = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\"]")).getText();
            String desc = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText();
            String timeText = driver.findElement(AppiumBy.id("com.google.android.keep:id/reminder_chip_text")).getText();
            Assert.assertEquals(title, "Mega Book Fair");
            Assert.assertEquals(desc, "Organized By Alchemy");
            Assert.assertEquals(timeText,"Today, 6:00 pm");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}