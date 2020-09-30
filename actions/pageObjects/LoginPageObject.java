package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	
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
		return new HomePageObject();
	}

}
