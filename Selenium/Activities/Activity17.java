package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title:" + driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("4");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> allOptions = select.getOptions();
        for (WebElement option:allOptions){
            System.out.println(option.getText());
        }

        driver.quit();
    }
}
