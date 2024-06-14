package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title:" + driver.getTitle());

        if(driver.findElement(By.id("dynamicText")).isEnabled()){
            System.out.println("Dynamic Text Field");
        }else {
            System.out.println("Dynamic Text is Not Enabled");
        }

        driver.findElement(By.id("toggleInput")).click();

        if(driver.findElement(By.id("dynamicText")).isDisplayed()){
            System.out.println("Dynamic Text is Not Enabled");
        }else {
            System.out.println("Dynamic Text is Not Enabled");
        }
        driver.quit();
    }

}
