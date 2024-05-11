package datadriven;

//public class OrangeHRMTest {

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class OrangeHRMTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set ChromeDriver path
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Navigate to OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1, groups = {"sanity"})
    public void loginTest() {
        // Locate username and password fields
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
     //   WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();

        // Enter username and password
        usernameField.sendKeys("admin");
        passwordField.sendKeys("admin123");

        // Click on login button
        loginButton.click();

        // Verify login is successful
        WebElement dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
        Assert.assertTrue(dashboardText.isDisplayed(), "Login not successful");
    }

    @Test(priority = 2, groups = {"regression"})
    public void logoutTest() {
        // Click on welcome menu
        WebElement welcomeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
        welcomeMenu.click();

        // Click on logout link
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));
        logoutLink.click();

        // Verify logout is successful
        WebElement loginPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));
        Assert.assertTrue(loginPanel.isDisplayed(), "Logout not successful");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
