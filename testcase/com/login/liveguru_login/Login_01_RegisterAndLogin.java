package com.login.liveguru_login;

import org.testng.annotations.Test;

import pageObjects_liveguru.HomePageObject_liveguru;
import pageObjects_liveguru.LoginPageObject_liveguru;
import pageObjects_liveguru.RegisterPageObject_liveguru;

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
	private HomePageObject_liveguru homepage;
	String email = "automation" + randomNumber() + "gmail.com";
	String password = "123456789";
	private HomePageObject_liveguru homePage;
	private LoginPageObject_liveguru loginPage;
	private RegisterPageObject_liveguru registerPage;
	
			

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
		homepage = new HomePageObject_liveguru(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test

	public void TC_01_LoginWithEmptyEmailAndPassword() {
		loginPage = homePage.clickToMyAccountFooter();
		loginPage.sendKeyToEmailTextbox("");
		loginPage.sendKeyToPasswordTextbox("");
		loginPage.clickToLoginBtn();
		
	}

	@Test

	public void TC_02_LoginInvalidEmail() {

	}

	@Test

	public void TC_03_LoginIncorrectEmail() {

	}
	
	@Test

	public void TC_04_LoginIncorrecPassword() {

	}
	
	@Test

	public void TC_05_LoginWithPasswordLessThan6Chars() {

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