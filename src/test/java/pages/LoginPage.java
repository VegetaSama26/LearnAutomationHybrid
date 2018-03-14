package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="main_user_login") WebElement EnterEmail;
	@FindBy(name="password") WebElement EnterPassoword;
	@FindBy(id="login_button") WebElement LoginButton;
	@FindBy(xpath=".//*[@id='sc_uname']/a") WebElement welcomeTitle;
	
	public void loginApplication(String uname, String pwd) throws Exception
	{
		Thread.sleep(5000);
		EnterEmail.sendKeys(uname);
		Thread.sleep(5000);
		EnterPassoword.sendKeys(pwd);
		Thread.sleep(5000);
		LoginButton.click();
		Thread.sleep(5000);
	}
	
	public String verifyHomePage()
	{
		return welcomeTitle.getText();
	}
}
