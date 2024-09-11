package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1']")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        WebElement cmpName = driver.findElement(By.id("experience_employer"));
        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));

        cmpName.clear();
        jobTitle.clear();

        cmpName.sendKeys("Orange");
        jobTitle.sendKeys("Service Engineer");

        driver.findElement(By.id("btnWorkExpSave")).click();


        driver.quit();
    }
}
