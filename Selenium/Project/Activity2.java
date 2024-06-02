package Acticities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/orangehrm");
        String imgUrl = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).getAttribute("src");
        System.out.println("Url=" + imgUrl);

        driver.quit();
    }
}
