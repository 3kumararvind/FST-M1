package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("Title: " + driver.getTitle());

        String text1=driver.findElement(By.xpath("//h3[contains(text(), 'Third header')]")).getText();

        System.out.println("Text: "+ text1);

        String color = driver.findElement(By.xpath("//h5[contains(text(), 'Fifth header')]")).getCssValue("color");
        System.out.println("Color: " + color);

        String violetButton = driver.findElement(By.xpath("//button[text(), 'violet")).getText()



    }
}
