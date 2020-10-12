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
		waitToElementVisible(driver, LoginPageUI_liveguru.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI_liveguru.EMAIL_TEXTBOX, emailValue);
		
	}

	public void sendKeyToPasswordTextbox(String passValue) {
		waitToElementVisible(driver, LoginPageUI_liveguru.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI_liveguru.PASSWORD_TEXTBOX, passValue);
		
	}

	public void clickToLoginBtn() {
		waitToElementClickable(driver, LoginPageUI_liveguru.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI_liveguru.LOGIN_BUTTON);
		
	}

	public boolean isEmptyEmailErrorMessageDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE, errorMsg));
		return isElementDisplayed(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE, errorMsg));
	}

	public boolean isEmptyPasswordErrorMessageDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_PASS,errorMsg));
		return isElementDisplayed(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE, errorMsg));
	}

	public boolean InvalidEmailErrorMsgDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_INVALID_EMAIL, errorMsg));
		return isElementDisplayed(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_INVALID_EMAIL, errorMsg));
	}

	public boolean PasswordLessThan6Chars(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.PASSWORD_LESS_THAN_6_CHARACTERS, errorMsg));
		return isElementDisplayed(driver, String.format(LoginPageUI_liveguru.PASSWORD_LESS_THAN_6_CHARACTERS, errorMsg));
	}

	public boolean isEmailNotExistOrInvalidPasswordErrorMsgDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD, errorMsg));
		return isElementDisplayed(driver,String.format(LoginPageUI_liveguru.ERROR_MESSAGE_NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD, errorMsg));
	}

	public boolean isIncorrectPassErrorMsgDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD, errorMsg));
		return isElementDisplayed(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD, errorMsg));
	}

	
	
	
}
