package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='logo-wrap is-image-logo site-branding']//child::img[@class='logo-default' and @alt='TechBeamers']") 
	private	WebElement logo;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchbar;
	
	@FindBy(xpath = "//div[@class='search-form-submit']//child::input[@type='submit']")
	private WebElement searchbtn;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	}
	
	public boolean isLogoPresent() {
		boolean logoFlag=logo.isDisplayed();
		return logoFlag;
	}
	public void clickOnLogo() {
		logo.click();
	}
	
	public boolean isSearchbarPresent() {
		boolean searchBarFlag=searchbar.isDisplayed();
		
		return searchBarFlag;
	}
	
	public void setSearchbarField(String input) {
		searchbar.sendKeys(input);
	}
	
	public boolean isSearchButtonPresent() {
		boolean searchBtnFlag=searchbtn.isDisplayed();
		return searchBtnFlag;
	}
	
	public void clickSearchButton() {
		searchbtn.click();
	}
	

	
}
