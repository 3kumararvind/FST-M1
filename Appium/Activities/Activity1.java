package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.miui.calculator")
                .setAppActivity(".cal.CalculatorActivity")
                .noReset();

        //set server URLS
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize the Android Driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void multiply_Test(){
        // Find the number 7 and Tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_7")).click();
        //find the multiply symbol and Tap it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //find the number 6 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_6")).click();
        //find the symbol equal to and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //Get the result value
        String mulResult = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        //assertions

        Assert.assertEquals(mulResult,"= 42");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
