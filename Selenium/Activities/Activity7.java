package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println("Title:" + driver.getTitle());
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        WebElement dropZone2 = driver.findElement(By.id(("dropzone2")));

        builder.dragAndDrop(football,dropZone1).build().perform();

        String dropzoneText1 = driver.findElement(By.tagName("p")).getText();

        if(dropzoneText1.equalsIgnoreCase("Dropped!")){
            System.out.println("Ball is in Dropzone 1");
        }

        builder.dragAndDrop(football,dropZone2).build().perform();

        String dropZoneText2 = driver.findElement(By.tagName("p")).getText();

        if(dropZoneText2.equalsIgnoreCase("Dropped!")){
            System.out.println("Ball in Drop zone 2");
        }
        driver.quit();

    }
}
