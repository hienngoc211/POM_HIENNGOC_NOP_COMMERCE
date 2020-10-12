package com.framework.datatable;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Handle_Dynamic_DataTable_Grid extends AbstractPages {
	WebDriver driver;
	String locator;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_mac");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Click_To_Page() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		goToPageByPageNumber("5");
		sleepInSecond(5);
		goToPageByPageNumber("10");
		sleepInSecond(5);
		goToPageByPageNumber("17");
		sleepInSecond(5);
	}

	// Go to page by page number
	
		public void goToPageByPageNumber(String pageNumber) {
			locator = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
			waitToElementClickable(driver, locator, pageNumber);
			clickToElement(driver, locator, pageNumber);
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
