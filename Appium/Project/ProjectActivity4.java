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
import java.util.List;

import static Examples.W3CActionsBase.doSwipe;

public class ProjectActivity4 {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");

    }
    @Test
    public void WebAppTest() throws InterruptedException {
        Dimension dim =driver.manage().window().getSize();
       // wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath()));

        Point start = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.8) );
        Point end = new Point((int)(dim.getWidth()*0.5), (int)(dim.getHeight()*0.6));
        doSwipe(driver, start, end, 200);

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'To-Do List')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));

        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]"));

        addTaskInput.sendKeys("List 1 added");
        addTaskButton.click();
        Thread.sleep(1000);

        addTaskInput.sendKeys("List 2 added");
        addTaskButton.click();
        Thread.sleep(1000);

        addTaskInput.sendKeys("List 3 added");
        addTaskButton.click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();

        List<WebElement> taskAdded = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View"));
        Assert.assertEquals(taskAdded.size(), 0);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
