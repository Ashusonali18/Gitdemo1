package datadriven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrossBrowserTestingExample {
    private WebDriver chromeDriver;
    private WebDriver ieDriver;
    
    @BeforeMethod
    public void setUp() {
        // Set path to Chrome and Edge drivers
//        System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Softwares\\chromedriver-win64");
//        System.setProperty("webdriver.edge.driver", "D:\\Automation Testing\\Softwares\\edgedriver_win64");
    	
    	
    }
    @Test
    public void testLoginChrome() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        // Login test steps
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Change the duration accordingly
        driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed());
        Thread.sleep(3000);
    }
    
    @Test
    public void testEdgeBrowser() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
        // Login test steps
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Change the duration accordingly
        driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed());
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (ieDriver != null) {
            ieDriver.quit();
        }
    }
}


//- @AfterMethod: This is a TestNG annotation used in TestNG framework in Java. It indicates that 
//the annotated method will be executed after each test method runs. It's used for cleanup or 
//teardown tasks.
//
//- public void tearDown() {: This line defines a method named tearDown with a public access 
//modifier. It doesn't take any arguments and doesn't return any value (void).
//
//- if (chromeDriver != null) { chromeDriver.quit(); }: This checks if the chromeDriver object 
//is not null. If it's not null, it calls the quit() method on it. quit() is a Selenium WebDriver 
//method used to close the browser and kill the WebDriver instance. This ensures that any
//resources associated with the Chrome browser are properly released.
//
//- if (ieDriver != null) { ieDriver.quit(); }: Similarly, this checks if the ieDriver object is
//not null and calls the quit() method on it to close the Internet Explorer browser.
//
//So, this tearDown() method ensures that after each test method execution, any open browser 
//windows controlled by chromeDriver or ieDriver are properly closed to clean up resources and
//maintain a clean testing environment.