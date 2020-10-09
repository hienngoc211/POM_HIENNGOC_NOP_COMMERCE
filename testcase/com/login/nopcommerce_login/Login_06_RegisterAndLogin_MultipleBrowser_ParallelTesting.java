package com.login.nopcommerce_login;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects_nopcommerce.HomePageObject;
import pageObjects_nopcommerce.LoginPageObject;
import pageObjects_nopcommerce.RegisterPageObject;

public class Login_06_RegisterAndLogin_MultipleBrowser_ParallelTesting {

	WebDriver driver;
	Select select;
	WebDriverWait wait;
	String firstName = "Virus";
	String lastName = "Corona";
	String email = "coronavirus" + randomNumber() + "@hotmail.com";
	String company = "Kientoan";
	String password = "Abc1234";
	long longTimeOut = 30;
	String dob = "24";
	String mob = "February";
	String yob = "1985";
	String registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String UATUrl) {
//		System.out.println("Browser name = " + browserName);
//		System.out.println("UAT url= " + UATUrl);
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_mac");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("headless_chrome")) {
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if(browserName.equalsIgnoreCase("headless_firefox")){
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_mac");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		
		driver.get(UATUrl); 
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		}
	}
	@Test

	public void TC_01_RegisterToSystem() throws InterruptedException {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToMale();
		registerPage.inputToFirstName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.selectDateDropdown(dob);
		registerPage.selectMonthDropdown(mob);
		registerPage.selectYearDropdown(yob);
		registerPage.sendKeyToEmail(email);
		registerPage.sendKeyToCompany(company);
		registerPage.sendKeyToPassword(password);
		registerPage.sendKeyToConfirmPassWord(password);
		registerPage.clickToRegisterBtn();
		registerSuccessMsg = registerPage.getRegisterSuccessMsg();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		homePage = registerPage.clickToLogoutBtn();

	}

	@Test

	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginLink();
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.sendKeyToPasswordTextBox(password);
		homePage = loginPage.clickToLoginBtn();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}

}
