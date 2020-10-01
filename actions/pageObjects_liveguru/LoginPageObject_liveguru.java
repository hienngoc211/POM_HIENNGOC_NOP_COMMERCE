package pageObjects_liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs_liveguru.LoginPageUI_liveguru;
import pageUIs_nopcommerce.LoginPageUI;

public class LoginPageObject_liveguru extends AbstractPages {
	private WebDriver driver;
	
	public LoginPageObject_liveguru(WebDriver _driver) {
		driver = _driver;
	}

	public void sendKeyToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI_liveguru.EMAIL_TEXTBOX, emailValue);
		
	}

	public void sendKeyToPasswordTextbox(String passValue) {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI_liveguru.PASSWORD_TEXTBOX, passValue);
		
	}

	public void clickToLoginBtn() {
		waitToElementClickable(driver, LoginPageUI_liveguru.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI_liveguru.LOGIN_BUTTON);
		
	}

	
	
	
}
