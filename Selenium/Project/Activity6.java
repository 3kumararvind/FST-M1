package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity6 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        WebElement dmenu = driver.findElement(By.id("menu_directory_viewDirectory"));

        if(dmenu.isDisplayed() && dmenu.isEnabled()){
            dmenu.click();
            dmenu.click();
        }

        String heading = driver.findElement(By.tagName("h1")).getText();

        if(heading.equalsIgnoreCase("Search Directory")){
            System.out.println("Heading Matched");
        }else {
            System.out.println("Heading not matched");
        }
        driver.quit();
    }
}
