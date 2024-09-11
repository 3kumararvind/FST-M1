package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Mahesh");
        driver.findElement(By.id("lastName")).sendKeys("Singh");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Mahesh Singh");
        driver.findElement(By.id("searchBtn")).click();

        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='resultTable']/table/tbody/tr/td[1]"));

        System.out.println("Size =" + rows.size());
        driver.quit();
    }
}
