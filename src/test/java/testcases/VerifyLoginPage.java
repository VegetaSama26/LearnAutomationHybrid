package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	ConfigDataProvider config;
	
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getBrowser("Chrome");
		
		config=new ConfigDataProvider();
	}

	@Test
	public void testHomePage() throws Exception {
		
		
		driver.get(config.getApplicationURL());
		
		HomePage page=PageFactory.initElements(driver, HomePage.class);
		page.getAppTitle().contains("ShopClues.com");
//		Assert.assertTrue(page.getAppTitle().contains("Shopclues.com"));
		System.out.println("The title of the page is : "+page.getAppTitle());
		System.out.println("You are at the correct page that is Homepage");
		
		page.clickonSignIN();
	
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcel().getData("Login",0 ,0), DataProviderFactory.getExcel().getData("Login",0,1));
		
		String LoginText=login.verifyHomePage();
		if(LoginText.contains("Hi"))
			System.out.println("You are at the correct page");
		else
			System.out.println("Check the credentials again you are at the wrong page");
	}
	
	@AfterMethod
	public void closeSession() {
		
		BrowserFactory.closeBrowser(driver);
	}
}
