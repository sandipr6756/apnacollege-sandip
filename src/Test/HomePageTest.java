package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;


public class HomePageTest {
	WebDriver driver;
	HomePageObject hpo;
	
	@BeforeSuite
	void initSetup() {
		System.setProperty("webdriver.chrome.driver", "E:\\sandipsoftware\\chromeDriver\\chromedriver.exe");
		 driver =new ChromeDriver();
	}
	@BeforeTest
	void launchUrl() {
		driver.get("https://techbeamers.com/websites-to-practice-selenium-webdriver-online/#google_vignette");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@BeforeClass
	void initializeObject() {
		hpo=new HomePageObject(driver);

	}
	
	@Test(priority = 1)
	void urlTest() {
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://techbeamers.com/websites-to-practice-selenium-webdriver-online/#google_vignette","Url test is succssful");
		System.out.println("url test is successful");

	}
	@Test(priority = 2)
	void logoTest() {
		boolean actualLogo=hpo.isLogoPresent();
		Assert.assertTrue(actualLogo,"Logo test is successful");
		System.out.println("Logo test is successful");
	}
	
	@Test(priority = 3)
	void searchFieldText(){
		boolean searchFlag=hpo.isSearchbarPresent();
		Assert.assertTrue(searchFlag,"Search field is diplaying on home page");
		hpo.setSearchbarField("sql query");
		Assert.assertTrue(hpo.isSearchButtonPresent(), "Search Button present");
		hpo.clickSearchButton();
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
