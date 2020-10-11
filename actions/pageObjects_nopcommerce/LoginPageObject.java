package pageObjects_nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs_nopcommerce.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	WebDriverWait waitExplicit;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
	}
	
	public LoginPageObject(WebDriver _driver, WebDriverWait waitExplicit) {
		driver = _driver;
		this.waitExplicit = waitExplicit;
	}
	
	public void sendKeyToEmailTextBox(String emailValue) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL);
		sendKeyToElement(driver, LoginPageUI.EMAIL, emailValue);
	}

	public void sendKeyToPasswordTextBox(String passwordValue) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD);
		sendKeyToElement(driver, LoginPageUI.PASSWORD, passwordValue);
		
	}

	public HomePageObject clickToLoginBtn() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
