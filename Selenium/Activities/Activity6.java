package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");

        System.out.println("Title: " + driver.getTitle());

        action.sendKeys("A").build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        driver.quit();
    }
}
