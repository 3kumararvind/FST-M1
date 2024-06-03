package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static  void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");

        String title = driver.getTitle();
        System.out.println("Titl1: " + title);
        driver.findElement(By.id("about-link")).click();

        String title2 = driver.getTitle();
        System.out.println("About Us Title: "+ title2);

        driver.quit();
    }
}
