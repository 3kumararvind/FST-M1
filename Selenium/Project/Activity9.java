package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();


        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();

        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr"));

        for(WebElement row : rows) {
            System.out.println(row.getText());
        }
        driver.quit();
    }
}
