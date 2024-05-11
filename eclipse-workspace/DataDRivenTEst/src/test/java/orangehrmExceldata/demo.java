package orangehrmExceldata;

import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class demo {
    
    @Test
    public void contextMenuTest() throws InterruptedException {
        // Set the path to the ChromeDriver executable
      //  System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Softwares\\chromedriver-win64.exe");
        
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Open the webpage
        driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Implicitly wait for 3 seconds
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Find the element
        WebElement ele = driver.findElement(By.id("hot-spot"));
        
     // Create Actions object
        Actions actions = new Actions(driver);
        
        // Perform right-click operation
        actions.contextClick(ele).build().perform();
        
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Close the alert
        alert.accept();
        Thread.sleep(5000);
        
        // Close the browser
        driver.quit();
    }
}
