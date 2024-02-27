package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zigwheels.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//driver.quit();
		
		//search bar
		Actions act=new Actions(driver);
        WebElement newBikes=driver.findElement(By.xpath("(//a[@href='/newbikes'])[1]"));
        act.moveToElement(newBikes).perform();
        
        //Clicking Upcoming Bikes
        driver.findElement(By.xpath("//span[contains(text(),'Upcoming Bikes')]")).click();

		System.out.println("Test1");
		
		//Selecting Manufacturer
        WebElement manufacturer= driver.findElement(By.className("custom-select"));
    	Select drpdwn= new Select(manufacturer);
    	drpdwn.selectByVisibleText("Honda");
    	
    	System.out.println("Test2");
    	
    	//Scroll to view more and click
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	WebElement viewMore=driver.findElement(By.xpath("//img[@title='Honda Rebel 1100']"));
    	js.executeScript("arguments[0].scrollIntoView();",viewMore);
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[@class='zw-cmn-loadMore']")).click();
    	
    	System.out.println("Test3");
    	
    	//Getting names of the bikes
    	List<WebElement> bikenames = driver.findElements(By.xpath("//a[@data-track-label='model-name']"));
    	List<WebElement> prices = driver.findElements(By.xpath("//a[@data-track-label='model-name']/following-sibling::div[1]"));
    	List<WebElement> launch = driver.findElements(By.xpath("//a[@data-track-label='model-name']/following-sibling::div[2]"));
    		for (int i = 0; i < bikenames.size(); i++) 
    		{
    			String str = bikenames.get(i).getText();
    			String str1 = prices.get(i).getText();
   				String str2 = launch.get(i).getText();
  				String priceString = str1.replaceAll("[^\\d.]", "").replaceFirst("\\.(?=.*\\.)", "");
   				double price = Double.parseDouble(priceString);
   				
   		
   		
   		// Check if the price is under 4 lakh and print the bike details
    		if (price < 4.0) 
    		{
    			System.out.println(str);
    			System.out.println(str1);
    			System.out.println(str2+"\n");
    		}
    		}
    		System.out.println("Test4");
    		
    		//*****************************************************************************88//
    		
    		//Slecting used cars in chennai
    		driver.navigate().back();
        	Thread.sleep(2000);
        	WebElement usedCars=driver.findElement(By.xpath("(//a[@class='c-p'])[4]"));
        	act.moveToElement(usedCars).perform();// moving cursor to Used Cars
        	driver.findElement(By.xpath("//span[contains(text(),'Chennai')]")).click();//selecting Chennai
        	
        	//Scolling to popular models
        	WebElement scrollpop=driver.findElement(By.xpath("//div[contains(text(),'Popular Models')]"));
        	js.executeScript("arguments[0].scrollIntoView();",scrollpop);
        	Thread.sleep(1000);
        	String popularModel=driver.findElement(By.xpath("//div[@class='gsc_thin_scroll']")).getText();//extracting all popular models
        	
        	System.out.println("Popular Models of Used Cars in Chennai\n\n"+popularModel);
        	driver.navigate().back();
        	
        	//Login to google
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@id='des_lIcon']")).click();//clicking Login/Signup button
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Google')]"))).click();
    		
    		Thread.sleep(3000);

        	//driver.findElement(By.xpath("//span[contains(text(),'Google')]")).click();//clicking Google button
        	String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
        	Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
        	for (String handle : windowHandles) {
        	    if (!handle.equals(mainWindowHandle)) {
        	        driver.switchTo().window(handle); // Switch to the pop-up window
        	        break;
        	    }
        	}
        	String emailid="abc@123";
        	WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        	email.sendKeys(emailid);//entering invalid email id
        	//email.sendKeys(Keys.ENTER);
        	
        	//scroll to next
        	WebElement scrollnext=driver.findElement(By.xpath("(//span[@jsname=\\\"V67aGc\\\"])[2]"));
        	js.executeScript("arguments[0].scrollIntoView();",scrollnext);
        	
        	driver.findElement(By.xpath("(//span[@jsname=\"V67aGc\"])[2]")).click();//clicking 'Next' button
        	Thread.sleep(1000);
        	
        	String errorMsg=driver.findElement(By.xpath("//div[contains(text(),'Enter a valid')]")).getText();//getting error message
        	System.out.println("\nError Message for invalid Email ID \n"+ errorMsg);
        	
    		driver.quit();
    		
    		
    	

		

		
		

	}

}
