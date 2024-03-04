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
	
	//java -jar selenium-server-4.18.1.jar standalone    //grid
	// java -jar jenkins.war
	
	//**************************************************************************//
	@Test(priority = 1)//, groups = { "Smoke", "Regression" })
	public static void newBike() throws InterruptedException
	{
		
		getlogger().info("first log");
		HB=new HondaBike(driver);
		HB.dropDown();
		ss.screenshot("newBike");
		Assert.assertEquals(HB.upcomingBike.isDisplayed(), true);
		getlogger().info("first log");
		
	}
	
	//**************************************************************************//
	@Test(priority = 2)//, groups = { "Smoke", "Regression" })
	public static void upcomingBike() throws InterruptedException
	{
		getlogger().info("first log");
		HB=new HondaBike(driver);
		HB.clickUpcominBike();
		String name = driver.getTitle();
		System.out.println(name);
		String expected = "Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News";//Upcoming Bikes in India in India 2024-25, Check Price, Launch Date, Specs @ ZigWheels
		Assert.assertEquals(expected, name);
		
		
		wait.until(ExpectedConditions.visibilityOf(HB.manufacturer));
		ss.screenshot("upcomingBike");
		
	}
	
	//**************************************************************************//
	@Test(priority = 3)//, groups = { "Smoke", "Regression" })
	public static void manufacture_select()
	{
		
		HB=new HondaBike(driver);
		HB.selectManufacturer();
		
		String name = driver.getTitle();
		System.out.println(name);
		
		String expected = "Honda Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News";
		Assert.assertEquals(expected,name);
		
		ss.screenshot("manufacture_select");
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 4)//, groups = { "Smoke", "Regression" })
	public static void scrolldown()
	{
		HB=new HondaBike(driver);
		HB.scrollto();
		wait.until(ExpectedConditions.visibilityOf(HB.LoadMore));
		Assert.assertEquals(HB.LoadMore.isDisplayed(), true);
		ss.screenshot("scrolldown");
	}
	
	//**************************************************************************//
	
	@Test(priority = 5)//, groups = { "Smoke", "Regression" })
	public static void clickLoad() throws InterruptedException
	{
		
		
		HB=new HondaBike(driver);
		HB.clickLoadMore();
		
		ss.screenshot("clickLoad");
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 6)//, groups = { "Smoke", "Regression" })
	public static void Details() throws IOException
	{
		HB=new HondaBike(driver);
		HB.bikeDetails();
		
		ss.screenshot("Details");
	}
	
	//**************************************************************************//
	
	@Test(priority = 7)//, groups = { "Smoke", "Regression" })
	public static void NavigateBack() throws InterruptedException
	{
		driver.navigate().back();
		
		String urlYouAreSupposedToBeAt = "https://www.zigwheels.com/upcoming-bikes";
		Assert.assertEquals(driver.getCurrentUrl(), urlYouAreSupposedToBeAt);
		
		
		ss.screenshot("NavigateBack");
	}
	
	//**************************************************************************//
	
	@Test(priority = 8)//, groups = { "Smoke", "Regression" })
	public static void usedCars_dropdown() throws InterruptedException
	{
		UC=new UsedCars(driver);
		UC.used_Cars();
		
		Assert.assertEquals(UC.usedCar.isDisplayed(), true);
		
		ss.screenshot("usedCars_dropdown");
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 9)//, groups = { "Smoke", "Regression" })
	public static void call_select_channai() throws InterruptedException
	{
		UC=new UsedCars(driver);
		Assert.assertEquals(UC.city_Chennai.isDisplayed(), true);
		UC.select_chennai();
		ss.screenshot("call_select_channai");
	}
	
	//**************************************************************************//
	@Test(priority = 10)//, groups = { "Regression" })
	public static void scroll_popularcars()
	{
		UC=new UsedCars(driver);
		UC.scrolltopopularcars();
		wait.until(ExpectedConditions.visibilityOf(UC.scrollpop));
		Assert.assertEquals(UC.scrollpop.isDisplayed(), true);
		ss.screenshot("scroll_popularcars");
	}

	
	//**************************************************************************//
	
	@Test(priority = 11)//, groups = { "Regression" })
	public static void call_popular_cars() throws InterruptedException
	{
		UC=new UsedCars(driver);
		UC.display_cars();
		
		Assert.assertEquals(UC.popularModelweb.isDisplayed(), true);
		ss.screenshot("call_popular_cars");
	}
	
	//**************************************************************************//
	
	@Test(priority = 12)//, groups = { "Regression" })
	public static void NavigateBackto() throws InterruptedException
	{
		
		
		driver.navigate().back();
		
		String urlYouAreSupposedToBeAt = "https://www.zigwheels.com/upcoming-bikes";
		Assert.assertEquals(driver.getCurrentUrl(), urlYouAreSupposedToBeAt);
		
		ss.screenshot("NavigateBackto");
		
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 13)//, groups = { "Regression" })
	public static void click_login()
	{
		LG=new Login(driver);
		ss.screenshot("click_login");
		LG.clickLogin();
		
	}
	
	//**************************************************************************//
	
	@Test(priority = 14)//, groups = { "Regression" })
	public static void click_Google()
	{
		LG=new Login(driver);
		//Assert.assertEquals(LG.GoogleButton.isDisplayed(), true);
		LG.clickGoogle();
		ss.screenshot("click_Google");
	}
	
	//**************************************************************************//
	
	@Test(priority = 15)//, groups = { "Regression" })
	public static void Handle_Frame()
	{
		LG=new Login(driver);
		LG.handlingFrame();
		ss.screenshot("Handle_Frame");
	}
	
	//**************************************************************************//
	
	@Test(priority = 16)//, groups = { "Regression" })
	public static void Email_input() throws IOException
	{
		LG=new Login(driver);
		LG.input_Email();
		ss.screenshot("Email_input");
	}
	
	//**************************************************************************//
	
	@Test(priority = 17)//, groups = { "Regression" })
	public static void Error_Msg()
	{
		LG=new Login(driver);
		LG.show_error();
		String expectedMessege = "Enter a valid email or phone number";
		Assert.assertEquals(LG.show_error(), expectedMessege);
		System.out.println("Error Message for invalid Email ID ");
		System.out.println(LG.show_error());

		ss.screenshot("Error_Msg");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
