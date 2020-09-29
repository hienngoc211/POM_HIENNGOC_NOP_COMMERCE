package com.login.nopcommerce_login;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin_AbstractPage {

	WebDriver driver;
	Select select;
	WebDriverWait wait;

	String firstName = "Virus";
	String lastName = "Corona";
	String email = "coronavirus" + randomNumber() + "@hotmail.com";
	String company = "Kientoan";
	String password = "Abc1234";
	private AbstractPage abstractPage;
	long longTimeOut = 15;
	String dob = "24";
	String mob = "February";
	String yob = "1985";
	

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
		abstractPage = new AbstractPage(driver);
		abstractPage.openUrl("http://demo.nopcommerce.com");
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test

	public void TC_01_RegisterToSystem() {
		abstractPage.clickToElement("//a[@class='ico-register']");
		abstractPage.clickToElement("//input[@value='M']");
		abstractPage.sendKeyToElement("//input[@id='FirstName']", firstName);
		abstractPage.sendKeyToElement("//input[@id='LastName']", lastName);
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", dob );
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", mob);
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", yob);
		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		abstractPage.sendKeyToElement("//input[@id='Company']", company);
		abstractPage.sendKeyToElement("//input[@id='Password']", password);
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password);
		abstractPage.clickToElement("//input[@id='register-button']");
		String msgSuccess = driver.findElement(By.className("result")).getText();
		Assert.assertEquals(msgSuccess, "Your registration completed");
		System.out.println("message success: " + msgSuccess);
		abstractPage.clickToElement("//a[@class='ico-logout']");

	}

	@Test

	public void TC_02_LoginToSystem() {
		abstractPage.clickToElement("//a[@class='ico-login']");
		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		abstractPage.sendKeyToElement("//input[@id='Password']", password);
		abstractPage.clickToElement("//input[@class='button-1 login-button']");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
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
