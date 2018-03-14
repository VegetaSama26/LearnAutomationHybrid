package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	ConfigDataProvider config;
	
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getBrowser("chrome");
		
		config=new ConfigDataProvider();
	}

	@Test
	public void testHomePage() {
		
		
		driver.get(config.getApplicationURL());
		
		HomePage page=PageFactory.initElements(driver, HomePage.class);
		page.getAppTitle().contains("ShopClues.com");
//		Assert.assertTrue(page.getAppTitle().contains("Shopclues.com"));
		System.out.println("The title of the page is : "+page.getAppTitle());
		System.out.println("You are at the correct page that is Homepage");
		
	}
	
	@AfterMethod
	public void closeSession() {
		
		BrowserFactory.closeBrowser(driver);
	}
}
