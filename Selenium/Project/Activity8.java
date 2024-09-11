package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity8 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();


        driver.findElement(By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a")).click();
        driver.findElement(By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a")).click();

        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");

        WebElement fromDate= driver.findElement(By.id("applyleave_txtFromDate"));
        fromDate.clear();
        fromDate.sendKeys("2024-09-11");
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        toDate.clear();
        toDate.sendKeys("2024-09-15");
        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        WebElement fromDate1 = driver.findElement(By.id("calFromDate"));
        fromDate1.clear();

        WebElement toDate1 = driver.findElement(By.id("calToDate"));
        toDate1.clear();

        fromDate1.sendKeys("2024-09-01");
        toDate1.sendKeys("2024-09-15");

        driver.findElement(By.id("btnSearch"));

        String leaveStatus = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]")).getText();

        System.out.println("Current Status:" + leaveStatus);
        driver.quit();
    }
}
