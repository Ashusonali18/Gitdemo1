import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// import Selenium_interview_Questions.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class closetab {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.gecko.driver","D:\\Automation Testing\\Softwares\\edgedriver_win64");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get(" https://the-internet.herokuapp.com/");
		
		driver.findElement(By.tagName("a"));
	}

}
