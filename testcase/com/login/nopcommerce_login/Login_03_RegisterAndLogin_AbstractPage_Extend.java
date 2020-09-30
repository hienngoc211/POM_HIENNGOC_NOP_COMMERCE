package com.login.nopcommerce_login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_03_RegisterAndLogin_AbstractPage_Extend extends AbstractPages {	

	WebDriver driver;
	Select select;
	WebDriverWait wait;
	String firstName = "Virus";
	String lastName = "Corona";
	String email = "coronavirus" + randomNumber() + "@hotmail.com";
	String company = "Kientoan";
	String password = "Abc1234";
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
		openUrl(driver, "http://demo.nopcommerce.com");
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test

	public void TC_01_RegisterToSystem() {
		clickToElement(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//input[@value='M']");
		sendKeyToElement(driver,"//input[@id='FirstName']", firstName);
		sendKeyToElement(driver,"//input[@id='LastName']", lastName);
		selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']", dob);
		selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']", mob);
		selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']", yob);
		sendKeyToElement(driver,"//input[@id='Email']", email);
		sendKeyToElement(driver,"//input[@id='Company']", company);
		sendKeyToElement(driver,"//input[@id='Password']", password);
		sendKeyToElement(driver,"//input[@id='ConfirmPassword']", password);
		clickToElement(driver,"//input[@id='register-button']");
		String msgSuccess = driver.findElement(By.className("result")).getText();
		Assert.assertEquals(msgSuccess, "Your registration completed");
		System.out.println("message success: " + msgSuccess);
		clickToElement(driver,"//a[@class='ico-logout']");

	}

	@Test

	public void TC_02_LoginToSystem() {
		clickToElement(driver,"//a[@class='ico-login']");
		sendKeyToElement(driver,"//input[@id='Email']", email);
		sendKeyToElement(driver,"//input[@id='Password']", password);
		clickToElement(driver,"//input[@class='button-1 login-button']");
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
