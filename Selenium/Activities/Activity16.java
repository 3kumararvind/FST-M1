package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of page:" + driver.getTitle());

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("testuser");
        driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys("testpassword");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input")).sendKeys("testpassword");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        WebElement actncnfrm = driver.findElement(By.id("action-confirmation"));
        wait.until(ExpectedConditions.invisibilityOf(actncnfrm));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Final Message: " + message);
        driver.quit();
    }
}
