package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPages;
import pageUIs_nopcommerce.HomePageUI;

public class HomePageObject extends AbstractPagesFactory {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(xpath = "//div[@class='header-links']//a[contains(text(),'My account')]")
	private WebElement myAccountLink;

	// Cach 1
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}
	
	// Cach 2
//	public void clickToRegisterLink() {
//		waitToElementClickable(driver, registerLink);
//		clickToElement(driver, registerLink);
//	}
//	
	

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink) ;
	}
	
	
	

}
