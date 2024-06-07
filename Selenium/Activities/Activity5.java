package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");

        System.out.println("Title: " + driver.getTitle());

        WebElement element = driver.findElement(By.id("side3"));
        element.click();

        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println("Front Text: " + frontText);

        action.doubleClick().pause(1000).build().perform();
        System.out.println("Front Text: " + driver.findElement(By.className("active")).getText());

        action.contextClick().pause(1000).build().perform();;
        System.out.println("Front Text: " + driver.findElement(By.className("active")).getText());
        driver.quit();


    }
}
