package com.login.liveguru_login;

import org.testng.annotations.Test;

import pageObjects_liveguru.HomePageObject_liveguru;
import pageObjects_liveguru.LoginPageObject_liveguru;
import pageObjects_liveguru.DashboardPageObject_liveguru;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_01_RegisterAndLogin {

	WebDriver driver;
	private HomePageObject_liveguru homePage;
	private LoginPageObject_liveguru loginPage;
	private DashboardPageObject_liveguru myDashboardPage;
	private String email = "automationfc" + randomNumber() + "@gmail.com";

			

	@BeforeTest
	public void beforeTest() {
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
		} else if (osName.toLowerCase().contains("mac")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_mac");
		} else {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_linux");

		}
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/index.php");
		homePage = new HomePageObject_liveguru(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test

	public void TC_01_LoginWithEmptyEmailAndPassword() {
		loginPage = homePage.clickToMyAccountFooter();
		loginPage.sendKeyToEmailTextbox("");
		loginPage.sendKeyToPasswordTextbox("");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed("This is a required field."));
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed("This is a required field."));

	}

//	@Test

	public void TC_02_LoginInvalidEmail() {
		loginPage.sendKeyToEmailTextbox("123@123.789");
		loginPage.sendKeyToPasswordTextbox("123123");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(loginPage.InvalidEmailErrorMsgDisplayed("Please enter a valid email address. For example johndoe@domain.com."));
		
	}

	@Test

	public void TC_03_LoginEmailNotExist() {
		loginPage.sendKeyToEmailTextbox("automationfc" + randomNumber() + "@gmail.com");
		loginPage.sendKeyToPasswordTextbox("123456789");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(loginPage.isEmailNotExistOrInvalidPasswordErrorMsgDisplayed("Invalid login or password."));

	}
	
	
	@Test

	public void TC_04_LoginWithPasswordLessThan6Chars() {
		loginPage.sendKeyToEmailTextbox("automationfc" + randomNumber() + "@gmail.com");
		loginPage.sendKeyToPasswordTextbox("12d");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(loginPage.PasswordLessThan6Chars("Please enter 6 or more characters without leading or trailing spaces."));

	}
	
	@Test
	
	public void TC_05_LoginWithIncorrectPassword() {
		loginPage.sendKeyToEmailTextbox("automationfc.vn@gmail.com");
		loginPage.sendKeyToPasswordTextbox("123erthg");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(loginPage.isEmailNotExistOrInvalidPasswordErrorMsgDisplayed("Invalid login or password."));
	}
		@Test
	
	public void TC_06_LoginWithValidEmailAndPassword() {
		loginPage.sendKeyToEmailTextbox("automationabc@gmail.com");
		loginPage.sendKeyToPasswordTextbox("123456789");
		loginPage.clickToLoginBtn();
		loginPage.clickToLoginBtn();
		myDashboardPage = new DashboardPageObject_liveguru(driver);
		Assert.assertTrue(myDashboardPage.isFullNameOrEmailDisplayed("automationFC Tester"));
		Assert.assertTrue(myDashboardPage.isFullNameOrEmailDisplayed("automationabc@gmail.com"));

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