package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Title: " + driver.getTitle());
        WebElement button = driver.findElement(By.className("orange"));
        builder.moveToElement(button).build().perform();
        String message = button.getAttribute("data-tooltip");
        System.out.println(message);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String message1 = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message1);
        driver.quit();
    }
}
