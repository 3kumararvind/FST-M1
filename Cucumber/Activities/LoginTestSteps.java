package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void whenUserIsOnLoginPage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password$")
    public void userEntersUsernameAndPassword(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @When("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) throws Throwable{
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void readPageTitleAndConfirmationMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String pageTitle = driver.getTitle();
        String message = driver.findElement(By.id("action-confirmation")).getText();

        System.out.println("Page Title:" + pageTitle);
        System.out.println("Confirmation Message:" + message);

        if(message.contains("admin")) {
            Assert.assertEquals(message, "Welcome Back, admin");
        } else {
            Assert.assertEquals(message, "Invalid Credentials");
        }
    }
    @And("^Close the Browser$")
    public void closeBrowser(){
        driver.quit();
    }
}
