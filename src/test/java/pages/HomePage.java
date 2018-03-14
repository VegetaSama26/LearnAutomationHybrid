package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement signInLink;
	@FindBy(xpath="//a[@href='https://secure.shopclues.com/atom/acart/getcart']") WebElement cartLink;
	@FindBy(xpath=".//*[@id='wishlist_d']/a") WebElement wishlistLink;
	@FindBy(xpath=".//*[@id='call_us']/a") WebElement callusLink ;
	
	public void clickonSignIN()
	{
		signInLink.click();
	}
	public void clickonCartLink()
	{
		cartLink.click();
	}
	public void clickonWishlistLink()
	{
		wishlistLink.click();
	}
	public void clickonCallusLink()
	{
		callusLink.click();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
}
