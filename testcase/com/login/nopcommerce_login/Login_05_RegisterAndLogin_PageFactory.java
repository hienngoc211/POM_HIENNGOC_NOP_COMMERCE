package com.login.nopcommerce_login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.nopcommerce.HomePageObject;
import pageFactory.nopcommerce.LoginPageObject;
import pageFactory.nopcommerce.RegisterPageObject;

public class Login_05_RegisterAndLogin_PageFactory {	

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
		driver.get("http://demo.nopcommerce.com"); 
		homePage = new HomePageObject(driver);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test

	public void TC_01_RegisterToSystem() throws InterruptedException {
//		clickToElement(driver,"//a[@class='ico-register']");
		registerPage = homePage.clickToRegisterLink();
//		clickToElement(driver,"//input[@value='M']");
		registerPage.clickToMale();
		Thread.sleep(3000);
//		sendKeyToElement(driver,"//input[@id='FirstName']", firstName);
		registerPage.inputToFirstName(firstName);
//		sendKeyToElement(driver,"//input[@id='LastName']", lastName);
		registerPage.inputToLastName(lastName);
//		selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']", dob);
		registerPage.selectDateDropdown(dob);
//		selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']", mob);
		registerPage.selectMonthDropdown(mob);
//		selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']", yob);
		registerPage.selectYearDropdown(yob);
//		sendKeyToElement(driver,"//input[@id='Email']", email);
		registerPage.sendKeyToEmail(email);
//		sendKeyToElement(driver,"//input[@id='Company']", company);
		registerPage.sendKeyToCompany(company);
//		sendKeyToElement(driver,"//input[@id='Password']", password);
		registerPage.sendKeyToPassword(password);
//		sendKeyToElement(driver,"//input[@id='ConfirmPassword']", password);
		registerPage.sendKeyToConfirmPassWord(password);
//		clickToElement(driver,"//input[@id='register-button']");
		registerPage.clickToRegisterBtn();
//		String msgSuccess = driver.findElement(By.className("result")).getText();
//		Assert.assertEquals(msgSuccess, "Your registration completed");
//		System.out.println("message success: " + msgSuccess);
		registerSuccessMsg = registerPage.getRegisterSuccessMsg();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
//		clickToElement(driver,"//a[@class='ico-logout']");
		homePage = registerPage.clickToLogoutBtn();

	}

	@Test

	public void TC_02_LoginToSystem() {
//		clickToElement(driver,"//a[@class='ico-login']");
		loginPage = homePage.clickToLoginLink();
//		sendKeyToElement(driver,"//input[@id='Email']", email);
		loginPage.sendKeyToEmailTextBox(email);
//		sendKeyToElement(driver,"//input[@id='Password']", password);
		loginPage.sendKeyToPasswordTextBox(password);
//		clickToElement(driver,"//input[@class='button-1 login-button']");
		homePage = loginPage.clickToLoginBtn();
//		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
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
