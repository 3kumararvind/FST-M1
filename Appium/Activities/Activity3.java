package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.miui.calculator");
        options.setAppActivity(".cal.CalculatorActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
    }
    @Test(priority = 1)
    public void testAdd(){
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();

        String addResult = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();

        Assert.assertEquals(addResult, "= 14");

    }
    @Test(priority = 2)
    public void subTest(){
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();


        Assert.assertEquals(result, "= 5");
    }
    @Test(priority = 3)
    public void multiplyTest(){

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();


        Assert.assertEquals(result, "= 500");
    }
    @Test(priority = 4)
    public void divTest(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/op_div")).click();
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "= 25");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
