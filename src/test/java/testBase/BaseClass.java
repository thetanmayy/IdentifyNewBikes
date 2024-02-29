//package testBase;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeSuite;
//
//public class BaseClass {
//	
//	public static WebDriver driver;
//	public static String url = "https://www.zigwheels.com/";
//	public static WebDriverWait wait;
//	public static Logger logger;
//	public static Properties p;
//	
//	@BeforeSuite(groups = { "Smoke", "Regression" })
//	public void setup() throws IOException
//	{
//
//		driver = new ChromeDriver() ;
//		driver.get(url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));  
//		
//		logger = LogManager.getLogger(this.getClass());
//	}
//	
//	
//	
//	@AfterClass(groups = { "Smoke", "Regression" })
//	   public void tearDown()
//	   {
//			driver.quit();
//	   }
//
//}


package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public Properties p;
	public static WebDriverWait wait;
	


	@BeforeTest
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{

		//loading properties file

		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);

		//loading log4j 

		logger=LogManager.getLogger(this.getClass());//Log4j

		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")){
				capabilities.setPlatform(Platform.WINDOWS);
			}

			else if(os.equalsIgnoreCase("mac")){
				capabilities.setPlatform(Platform.MAC);
			}

			else{
				System.out.println("No matching os..");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		    }

		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
