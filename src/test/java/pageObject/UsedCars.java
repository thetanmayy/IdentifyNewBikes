package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage{
	public String datastr[];
	public UsedCars(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "(//a[@class='c-p'])[4]") 
	WebElement usedCar;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")  ///(//span[contains(text(),'Chennai')]
	WebElement city_Chennai;
	
	@FindBy(xpath = "//div[contains(text(),'Popular Models')]")
	WebElement scrollpop;
	
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']")
	String popularModel;
	
	//****************************************************************************************//
                                      //ACTION METHODS//
	//****************************************************************************************//

	//Hover to the used cars Dropdown
	public void used_Cars() throws InterruptedException  
	{
		Actions action=new Actions(driver);
		action.moveToElement(usedCar).perform();
		
	}
	public void select_chennai() throws InterruptedException  
	{
		city_Chennai.click();
	}
	public void scrolltopopularcars()
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView();",scrollpop);
	}
	public void display_cars()
	{
		
    	popularModel=driver.findElement(By.xpath("//div[@class='gsc_thin_scroll']")).getText();//extracting all popular models
    	System.out.println("Popular Models of Used Cars in Chennai\n\n"+popularModel);

	}
	
		
}
