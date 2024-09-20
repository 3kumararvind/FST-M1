package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

import static Examples.W3CActionsBase.doSwipe;

public class ProjectActivity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");
    }

    @Test(priority = 1)
    public void loginTestValid() throws InterruptedException {
        Dimension dim =driver.manage().window().getSize();

        Point start = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.8) );
        Point end = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.6));
        doSwipe(driver, start, end, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")));
        WebElement signInBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]"));
        signInBtn.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
        WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
        WebElement loginBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]"));

        username.sendKeys("admin");
        password.sendKeys("password");
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"action-confirmation\"]")));

        String msg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).getText();
        Assert.assertEquals(msg, "Welcome Back, admin");
    }
    @Test(priority = 2)
    public void loginTestInValid() throws InterruptedException {
        Dimension dim =driver.manage().window().getSize();

        Point start = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.8) );
        Point end = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.6));
        doSwipe(driver, start, end, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")));
        WebElement signInBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]"));
        signInBtn.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
        WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
        WebElement loginBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]"));

        username.sendKeys("admins");
        password.sendKeys("password");
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"action-confirmation\"]")));

        String msg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).getText();
        Assert.assertEquals(msg, "Invalid Credentials");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}