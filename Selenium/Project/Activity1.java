package Acticities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        String pageTitle = driver.getTitle();

        if(pageTitle.equalsIgnoreCase("OrangeHRM")){
            System.out.println("Title Matched");
            driver.quit();
        }
    }
}
