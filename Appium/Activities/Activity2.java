package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options cs = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,cs);

    }

    @Test
    public void testTrainingPageHeader(){
        driver.get("https://v1.training-support.net/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        System.out.println("Home page Heading=" + pageHeading);
        String aboutUsHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("About Us Heading=" + aboutUsHeading);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
