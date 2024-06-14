package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity10 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title:" + driver.getTitle());

        if(driver.findElement(By.className("willDisappear")).isDisplayed()){
            System.out.println("Toggle checkbox is found");
        }else {
            System.out.println("Toggle checkbox is not found");
        }

        driver.findElement(By.id("toggleCheckbox")).click();

        if(driver.findElement(By.className("willDisappear")).isDisplayed()){
            System.out.println("Toggle checkbox is found");
        }else {
            System.out.println("Toggle checkbox is not found");
        }
        driver.quit();
    }

}
