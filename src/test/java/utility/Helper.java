package utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String Destination="./Screenshots/"+screenshotName+System.currentTimeMillis()+".png";
		try {
			FileHandler.copy(src,new File( Destination));
		} catch (Exception e)
		{
		  System.out.println("The error is caught"+e.getMessage());
		}
		return Destination;
	}

}
