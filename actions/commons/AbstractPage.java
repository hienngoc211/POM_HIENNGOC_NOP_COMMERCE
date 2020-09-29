package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	private WebDriver driver;
	private long longTimeOut = 30;
	private Actions action;
	private WebElement element;
	private By byXpath;
	private WebDriverWait waitExplicit;
	private Select select;

	
	public AbstractPage(WebDriver localDriver) {
		driver = localDriver;
	}
	public void openUrl(String pageUrl) {
		driver.get(pageUrl);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void back() {
		driver.navigate().back();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}

	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public List<WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpathLocator(locator));
	}

	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}

	public void sendKeyToElement(String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
	}

	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}

	public String getAttributeElement(String locator, String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}

	public void hoverMouseToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.moveToElement(element).build().perform();
	}

	public void doubleClickToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.doubleClick().build().perform();
	}

	public void waitToElementDisplayed(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated((byXpath)));
	}

	public void waitToElementClickable(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	public void selectItemInDropdown(String locator, String valueItem) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}

}
