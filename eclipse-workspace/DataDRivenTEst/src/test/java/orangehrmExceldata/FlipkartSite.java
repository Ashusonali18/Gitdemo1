package orangehrmExceldata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSite {

	


			

public static void main(String[] args)   {
					// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "D:\\DurgaAutomatioProject\\chromedriver-win64\\chromedriver.exe");

			        // Initialize ChromeDriver
			        WebDriver driver = new ChromeDriver();

			        
			        driver.get("https://www.flipkart.com/");
			        //Thread.sleep(2000);
			        driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("POCO MOBILE");
			        driver.findElement(By.xpath("//button[@type='submit']")).click();
					
					
				}

			}
		

	
