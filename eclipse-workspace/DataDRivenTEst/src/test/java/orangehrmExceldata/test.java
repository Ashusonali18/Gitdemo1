package orangehrmExceldata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String args[]) throws InterruptedException {
        // Set the path to the ChromeDriver executable
     //   System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://www.ironspider.ca/forms/checkradio.htm");
        driver.manage().window().maximize();

        // Find the first checkbox using XPath
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'  and @value=\"red\"]"));

        // Check if the checkbox is not selected, then select it
        if (!checkbox1.isSelected()) {
            checkbox1.click(); // Select the checkbox
            System.out.println("Checkbox 1 selected.");
        } else {
            System.out.println("Checkbox 1 is already selected.");
        }
        
        
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    
}
}
