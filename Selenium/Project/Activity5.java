package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();

        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Ram");

        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Singh");

        driver.findElement(By.id("personal_optGender_1")).click();
        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        WebElement dob = driver.findElement(By.id("personal_DOB"));
        dob.clear();

        dob.sendKeys("1996-12-15");

        driver.findElement(By.id("btnSave")).click();

        driver.quit();



    }
}
