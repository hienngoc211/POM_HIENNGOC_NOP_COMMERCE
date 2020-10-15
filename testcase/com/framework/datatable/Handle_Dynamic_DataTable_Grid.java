package com.framework.datatable;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Handle_Dynamic_DataTable_Grid extends AbstractPages {
	WebDriver driver;
	String locator, total;
	int index;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_mac");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
	public void TC_01_Click_To_Page() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		goToPageByPageNumber("5");
		sleepInSecond(5);
//		Assert.assertTrue(isPageActivedByPageNumber("5"));
//		goToPageByPageNumber("10");
//		sleepInSecond(5);
//		Assert.assertTrue(isPageActivedByPageNumber("10"));
//		goToPageByPageNumber("17");
//		sleepInSecond(5);
//		Assert.assertTrue(isPageActivedByPageNumber("17"));
	}
	
//	@Test
	public void TC_02_Click_To_Icon_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		goToPageByPageNumber("5");
		sleepInSecond(5);
		clickToDynamicIconByCountryName("Central Asia", "remove");
		sleepInSecond(5);
		clickToDynamicIconByCountryName("China", "remove");
		sleepInSecond(5);
		goToPageByPageNumber("12");
		sleepInSecond(5);
		clickToDynamicIconByCountryName("Least developed countries", "edit");
		sleepInSecond(5);
		
	}
	
//	@Test
	public void TC_03_Get_Total_Value_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		total = getTotalValueByCountryName("Argentina");
		Assert.assertEquals(total, "687522");
		sleepInSecond(5);

	}
	
	@Test
	
	public void TC_04_Input_To_Textbox() {
		driver.get("http://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
//		inputToTextboxByColumnAndRowNumber("company", "2", "KMS");
		inputToTextboxByColumnAndRow("company", "2", "KMS");
		sleepInSecond(2);
//		inputToTextboxByColumnAndRowNumber("name", "1", "Automation");
		inputToTextboxByColumnAndRow("name", "1", "Automation");
		sleepInSecond(2);
	}
	
	
	
	
	// Go to page by page number
	
		public void goToPageByPageNumber(String pageNumber) {
			locator = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
			waitToElementClickable(driver, locator, pageNumber);
			clickToElement(driver, locator, pageNumber);
		}
		
		public boolean isPageActivedByPageNumber(String pageNumber) {
			locator = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
			waitToElementVisible(driver, locator, pageNumber);
			return isElementDisplayed(driver, locator, pageNumber);
		}
		
		public void clickToDynamicIconByCountryName(String countryName, String iconName) {
			locator = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
			waitToElementClickable(driver, locator, countryName, iconName );
			clickToElement(driver, locator, countryName, iconName);
		}
		
		public String getTotalValueByCountryName(String countryName) {
			locator = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total']";
			waitToElementVisible(driver, locator, countryName);
			return getTextElement(driver, locator, countryName);
			
		}
		
		public void inputToTextboxByColumnAndRowNumber(String columnName, String rowNumber, String value) {
			locator = "//input[@id='tblAppendGrid_%s_%s']";
			waitToElementVisible(driver, locator, columnName, rowNumber);
			sendKeyToElement(driver, locator,value,columnName, rowNumber);
		}
		
		public void inputToTextboxByColumnAndRow(String columnName, String rowNumber, String value) {
			// Công thêm với 1 để biết được idex chính xpath đó 
			locator = "count (//th[text()='%s']//preceding-sibling::th)";
			index = findElementsByXpath(driver, locator, columnName).size() + 1;
			locator = "//tr["+ rowNumber +"]//td["+ index +"]/input";
			waitToElementVisible(driver, locator);
			sendKeyToElement(driver, locator, value);
			
		}
		
		public void clickToIconByRowNumber(String iconName, String rowNumber) {
			
		}
		
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
