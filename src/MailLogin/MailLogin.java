package MailLogin;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.junit.Assert;

public class MailLogin {

	private WebDriver wd;
	private String url;
	private String userName;
	private String userPass;
	
	@Before
	public void setUp() {
		
		url = "https://www.wp.pl/";
		userName = "TwojLogin";
		userPass = "TwojeHaslo";
		System.setProperty("webdriver.gecko.driver", "C://Users/danie/Desktop/JUNIT i SELENIUM/geckodriver.exe");

		//Now you can Initialize marionette driver to launch firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		wd = new FirefoxDriver(); 
	}
	
	@Test
	public void loginNegative() {
		wd.get(url);
		wd.findElement(By.partialLinkText("Poczta")).click();
		
		WebElement loginName = wd.findElement(By.name("login_username"));
		loginName.clear();
		loginName.sendKeys(userName);
		
		WebElement loginPass = wd.findElement(By.id("password"));
		loginPass.clear();
		loginPass.sendKeys(userPass);
	
		wd.findElement(By.xpath("//input[@value='zaloguj']")).click();
	
		//Assert.assertTrue(wd.getPageSource().contains("Niestety podany login lub has³o jest b³êdne"));
	}
	
	/*
	@After
	public void tearDown() {
		wd.quit();
		
	}
	*/
}