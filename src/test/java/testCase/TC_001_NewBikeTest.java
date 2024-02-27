package testCase;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HondaBike;
import pageObject.Login;
import pageObject.UsedCars;
import testBase.BaseClass;
import utilities.For_ReadWriteExcel;
import utilities.For_Screenshot;

public class TC_001_NewBikeTest extends BaseClass{
	
	public static HondaBike HB ;
	public static UsedCars UC;
	public static Login LG;
	public static For_Screenshot ss = new For_Screenshot();
	public static For_ReadWriteExcel RWE = new For_ReadWriteExcel();
	
	
	//**************************************************************************//
	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public static void newBike() throws InterruptedException
	{
		HB=new HondaBike(driver);
		HB.dropDown();
		ss.screenshot("newBike");
		Assert.assertEquals(HB.upcomingBike.isDisplayed(), true);
		
		
	}
	
	//**************************************************************************//
	@Test(priority = 2, groups = { "Smoke", "Regression" })
	public static void upcomingBike() throws InterruptedException
	{
		
		HB=new HondaBike(driver);
		HB.clickUpcominBike();
		String name = driver.getTitle();
		System.out.println(name);
		String expected = "Upcoming Bikes in India in India 2024-25, Check Price, Launch Date, Specs @ ZigWheels";
		Assert.assertEquals(expected, name);
		
		wait.until(ExpectedConditions.visibilityOf(HB.manufacturer));
		ss.screenshot("upcomingBike");
	}
	
	//**************************************************************************//
	@Test(priority = 3, groups = { "Smoke", "Regression" })
	public static void manufacture_select()
	{
		HB=new HondaBike(driver);
		HB.selectManufacturer();
		
		String name = driver.getTitle();
		System.out.println(name);
		
		String expected = "Honda Upcoming Bikes in India in India 2024-25, Check Price, Launch Date, Specs @ ZigWheels";
		Assert.assertEquals(expected,name);
		
		ss.screenshot("manufacturer-Honda");
	}
	
	//**************************************************************************//
	
	@Test(priority = 4, groups = { "Smoke", "Regression" })
	public static void scrolldown()
	{
		HB=new HondaBike(driver);
		HB.scrollto();
		wait.until(ExpectedConditions.visibilityOf(HB.LoadMore));
		Assert.assertEquals(HB.LoadMore.isDisplayed(), true);
		ss.screenshot("Scroll-bottom");
	}
	
	//**************************************************************************//
	
	@Test(priority = 5, groups = { "Smoke", "Regression" })
	public static void clickLoad() throws InterruptedException
	{
		HB=new HondaBike(driver);
		HB.clickLoadMore();
		ss.screenshot("LoadMore");
	}
	
	//**************************************************************************//
	
	@Test(priority = 6, groups = { "Smoke", "Regression" })
	public static void Details() throws IOException
	{
		HB=new HondaBike(driver);
		HB.bikeDetails();
		
		ss.screenshot("BikeDetails");
	}
	
	//**************************************************************************//
	
	@Test(priority = 7, groups = { "Smoke", "Regression" })
	public static void NavigateBack() throws InterruptedException
	{
		driver.navigate().back();
//		Assert.assertEquals(driver.getCurrentUrl(), urlYouAreSupposedToBeAt);
		
		
		ss.screenshot("Navigating-Back");
	}
	
	//**************************************************************************//
	
	@Test(priority = 8, groups = { "Smoke", "Regression" })
	public static void usedCars_dropdown() throws InterruptedException
	{
		UC=new UsedCars(driver);
		UC.used_Cars();
		
		
		ss.screenshot("UsedCarDropdown");
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 9, groups = { "Smoke", "Regression" })
	public static void call_select_channai() throws InterruptedException
	{
		UC=new UsedCars(driver);
		UC.select_chennai();
		ss.screenshot("Selecting_Chennai");
	}
	
	//**************************************************************************//
	
	@Test(priority = 10, groups = { "Regression" })
	public static void call_popular_cars() throws InterruptedException
	{
		UC=new UsedCars(driver);
		UC.display_cars();
		
		
		ss.screenshot("Displaying Car");
	}
	
	//**************************************************************************//
	
	@Test(priority = 11, groups = { "Regression" })
	public static void scroll_popularcars()
	{
		UC=new UsedCars(driver);
		UC.scrolltopopularcars();
		ss.screenshot("Popular-Cars");
	}
	
	//**************************************************************************//
	
	@Test(priority = 12, groups = { "Regression" })
	public static void NavigateBackto() throws InterruptedException
	{
		driver.navigate().back();
	}
	
	//**************************************************************************//
	
	@Test(priority = 13, groups = { "Regression" })
	public static void click_login()
	{
		LG=new Login(driver);
		LG.clickLogin();
		ss.screenshot("Click-Login");
	}
	
	//**************************************************************************//
	
	@Test(priority = 14, groups = { "Regression" })
	public static void click_Google()
	{
		LG=new Login(driver);
		LG.clickGoogle();
		ss.screenshot("Click-Google");
	}
	
	//**************************************************************************//
	
	@Test(priority = 15, groups = { "Regression" })
	public static void Handle_Frame()
	{
		LG=new Login(driver);
		LG.handlingFrame();
		ss.screenshot("New-Frame");
	}
	
	//**************************************************************************//
	
	@Test(priority = 16, groups = { "Regression" })
	public static void Email_input() throws IOException
	{
		LG=new Login(driver);
		LG.input_Email();
		ss.screenshot("Inputting-Email");
	}
	
	//**************************************************************************//
	
	@Test(priority = 17, groups = { "Regression" })
	public static void Error_Msg()
	{
		LG=new Login(driver);
		LG.show_error();
		String expectedMessege = "Enter a valid email or phone number";
		Assert.assertEquals(LG.show_error(), expectedMessege);
		ss.screenshot("Error-Messege");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
