package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;



    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void pageTitleTest(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Target Practice");
    }
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest2() {
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest2() {
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }
        @AfterClass
    public void tearDown(){
        driver.close();
    }
}
