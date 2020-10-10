package com.login.nopcommerce_login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects_nopcommerce.HomePageObject;
import pageObjects_nopcommerce.LoginPageObject;
import pageObjects_nopcommerce.RegisterPageObject;


public class Login_06_RegisterAndLogin_MultipleBrowser_ParallelTesting extends AbstractTest {

	WebDriver driver;
	
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

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
//		System.out.println("Browser name = " + browserName);
//		System.out.println("UAT url= " + UATUrl);
		
//		Hứng driver từ AbstracTest vì driver được khởi tạo ban đầu từ AbstractTest, testcase chưa có driver, nếu gán vào ban đầu sẽ trả về Null Pointer Exception
		
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
				
	}

	@Test

	public void TC_01_RegisterToSystem(){
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