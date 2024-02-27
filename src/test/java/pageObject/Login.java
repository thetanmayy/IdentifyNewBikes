package pageObject;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.For_ReadWriteExcel;

public class Login extends BasePage{
	
	public Login(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//div[@id='des_lIcon']") 
	WebElement LoginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Google')]")  
	WebElement GoogleButton;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement inputEmail;
	
	String ErrorMsg;
	
	
	//****************************************************************************************//
    								//ACTION METHODS//
	//****************************************************************************************//
	
	public void clickLogin()
	{
		LoginButton.click();
	}
	public void clickGoogle()
	{
		GoogleButton.click();
	}
	public String handlingFrame()
	{
		String miniwindow = null;
		String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
    	Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
    	for (String handle : windowHandles) 
    	{
    	    if (!handle.equals(mainWindowHandle)) 
    	    {
    	        driver.switchTo().window(handle); // Switch to the pop-up window
    	        miniwindow = handle;
    	        break;
    	    }
    	}
    	return miniwindow;
	}
	public void input_Email() throws IOException
	{
//		
		String emailid=For_ReadWriteExcel.getCellData("./src/main/resources/test_IP_data.xlsx", "Sheet1", 0, 0);
		inputEmail.sendKeys(emailid);
		inputEmail.sendKeys(Keys.ENTER);
		
	}
	public String show_error()
	{
		ErrorMsg = driver.findElement(By.xpath("//div[contains(text(),'Enter a valid')]")).getText();//getting error message
    	System.out.println("\nError Message for invalid Email ID \n"+ ErrorMsg);
    	return ErrorMsg;
	}
	


}
