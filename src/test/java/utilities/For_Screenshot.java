package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.BaseClass;

public class For_Screenshot extends BaseClass {
	
	public static void screenshot(String name) 
	{
		TakesScreenshot ss = ((TakesScreenshot) driver);
			File src=ss.getScreenshotAs(OutputType.FILE);
		try 
		{
			File trg=new File("./Screenshot/"+name+".png"); //"-"+System.currentTimeMillis()+
			FileUtils.copyFile(src, trg);
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	

}
