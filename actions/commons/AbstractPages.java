package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects_nopcommerce.FooterMyAccountPageObject;
import pageObjects_nopcommerce.FooterNewProductsPageObject;
import pageObjects_nopcommerce.FooterSearchPageObject;
import pageObjects_nopcommerce.HomePageObject;
import pageUIs_nopcommerce.AbstractPageUI;

public abstract class AbstractPages {

	private long longTimeOut = 30;
	private Actions action;
	private WebElement element;
	private By byXpath;
	private WebDriverWait waitExplicit;
	private Select select;

	
	
	
	public void openUrl(WebDriver driver,String pageUrl) {
		driver.get(pageUrl);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void sendKeyToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}
	
	public By byXpathLocator(String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		return By.xpath(locator);
	}

	public WebElement findElementByXpath(WebDriver driver,String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	
	public WebElement findElementByXpath(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		return driver.findElement(byXpathLocator(locator));
	}

	
	public String getDynamicLocator(String locator, String...values){
		locator = String.format(locator, (Object[])values);
		return locator;
	}

	public List<WebElement> findElementsByXpath(WebDriver driver,String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		return driver.findElements(byXpathLocator(locator));
	}

	public void clickToElement(WebDriver driver,String locator) {
		findElementByXpath(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...values) {
		findElementByXpath(driver, locator, values).click();
	}

	public void sendKeyToElement(WebDriver driver,String locator, String value) {
//		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
	}
	
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int countElementNumber(WebDriver driver,String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	public String getAttributeElement(WebDriver driver,String locator, String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return findElementByXpath(driver, locator, values).isDisplayed();
	}

	public void hoverMouseToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).build().perform();
	}

	public void doubleClickToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.doubleClick().build().perform();
	}

	public void waitToElementVisible(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated((byXpath)));
	}
	
	public void waitToElementVisible(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated((byXpath)));
	}
		

	public void waitToElementClickable(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	public void waitToElementClickable(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	public void selectItemInDropdown(WebDriver driver,String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	public String getTextElement(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}
	
//	Open Footer Page - 23 pages => open 23 pages
	
	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	
	public FooterSearchPageObject openSearchPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getFooterSearchPageObject(driver);
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public FooterNewProductsPageObject openNewProductsPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		return PageGeneratorManager.getFooterNewProductsPageObject(driver);
	}


	//  Case 10-15 pages
	
	public AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
		clickToElement(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
		// Factory Pattern
		switch (pageName) {
		case "Search":		
			return PageGeneratorManager.getFooterSearchPageObject(driver);
		case "New products":
			return PageGeneratorManager.getFooterNewProductsPageObject(driver);
		default:
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		}
	}
	
	// Case more pages
	public void openFooterPagesByName(WebDriver driver, String pageName) {
	waitToElementClickable(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
	clickToElement(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
	}
}

	
