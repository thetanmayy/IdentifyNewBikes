package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static WebDriver driver;
	public static String url = "https://www.zigwheels.com/";
	public static WebDriverWait wait;
	public static Logger logger;
	public static Properties p;
	
	@BeforeSuite(groups = { "Smoke", "Regression" })
	public void setup() throws IOException
	{

		driver = new ChromeDriver() ;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));  
	}
	
	
	
	@AfterClass(groups = { "Smoke", "Regression" })
	   public void tearDown()
	   {
			driver.quit();
	   }

}
