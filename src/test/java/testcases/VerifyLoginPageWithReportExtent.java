package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReportExtent {
	
	WebDriver driver;
	ConfigDataProvider config;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		report=new ExtentReports("./Reports/LoginPageReport.html",true);
		
		logger=report.startTest("Verify test Login");
		
		driver=BrowserFactory.getBrowser("Chrome");
		
		config=new ConfigDataProvider();
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}

	@Test
	public void testHomePage() throws Exception {
		
		
		driver.get(config.getApplicationURL());
		
		HomePage page=PageFactory.initElements(driver, HomePage.class);
		page.getAppTitle().contains("ShopClues.com");
//		Assert.assertTrue(page.getAppTitle().contains("Shopclues.com"));
		System.out.println("The title of the page is : "+page.getAppTitle());
		System.out.println("You are at the correct page that is Homepage");
		logger.log(LogStatus.INFO, "You are at the correct page that is hompepage");
		
		page.clickonSignIN();
		
		logger.log(LogStatus.INFO, "Click on SignIn link");
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcel().getData("Login",0 ,0), DataProviderFactory.getExcel().getData("Login",0,1));
		
		logger.log(LogStatus.INFO, "You are validated properly");
		String LoginText=login.verifyHomePage();
		if(LoginText.contains("Hi"))
			System.out.println("You are at the correct page");
		else
			System.out.println("Check the credentials again you are at the wrong page");
		
		logger.log(LogStatus.INFO, "Again page is verified");
	}
	
	@AfterMethod
	public void closeSession() {
		
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
