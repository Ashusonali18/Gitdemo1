package orangehrmExceldata;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Screenshotcap {
		
		public static void main(String[] args) throws InterruptedException, Exception
		{
		//System.setProperty("WebDriver.chrome.driver", "c:\\chromedriver.exe");	
			WebDriver driver =new EdgeDriver();
			
			driver.get("https://demoqa.com");
			driver.manage().window().maximize();
//		Screenshot s= new Ashot().shootStrategy(shootingStrategies.viewportPasting(1000)).takescreenshot(driver);
//		ImageIO.write(S.getImage(),"PNG",new File("c:\\users\\darad\\eclipse-workspace\\Learn_Java\\Screenshot_normal");
			
			long timestap = Calendar.getInstance().getTime().getTime();
			System.out.println(timestap);
			TakesScreenshot scrshot =((TakesScreenshot)driver);  // driver will take screenshot
		
			File srcFile=scrshot.getScreenshotAs(OutputType.FILE);  // it will getScreenshotAs method to create image file
		//  File DestFile=new File((System.getProperty("user.dir")+"\\Screenshot_normal"+timeStamp+".png")); // where
			File DestFile = new File(("C:\\Users\\Shree\\eclipse-workspace\\DataDRivenTEst\\src\\test\\java" +timestap + ".png"));  
			// where the screenshot should go
		
		//c:\\users\\darad\\eclipse-workspace\\Learn_Java\\Screenshot_normal.
			
		//copy file at destination
			FileUtils.copyFile(srcFile,DestFile);	
			driver.quit();
		}
	}


