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

	public String isDisplayedErrorMsg(String errorMsg) {
		waitToElementDisplayed(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE, errorMsg));
		getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE);
	}

	public boolean isDisplayedErrorMsgPass(String string) {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_PASS);
		getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE_PASS);
		return isElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_PASS);
	}

	public boolean InvalidEmailErrorMsgDisplayed(String invalidMsg) {
		waitToElementClickable(driver, String.format(LoginPageUI_liveguru.ERROR_MESSAGE_INVALID_EMAIL, invalidMsg));
		getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INVALID_EMAIL);
		return isElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INVALID_EMAIL);
	}

	public boolean IncorrectEmailMsgDisplayed() {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_EMAIL);
		getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_EMAIL);
		return isElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_EMAIL);
	}

	public boolean IncorrectPasslMsgDisplayed() {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_PASS);
		getTextElement(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_PASS);
		return isElementDisplayed(driver, LoginPageUI_liveguru.ERROR_MESSAGE_INCORRECT_PASS);
	}

	public boolean PasswordLessThan6Chars() {
		waitToElementDisplayed(driver, LoginPageUI_liveguru.PASSWORD_LESS_THAN_6_CHARACTERS);
		getTextElement(driver, LoginPageUI_liveguru.PASSWORD_LESS_THAN_6_CHARACTERS);
		return isElementDisplayed(driver, LoginPageUI_liveguru.PASSWORD_LESS_THAN_6_CHARACTERS);
	}

	
	
	
}
