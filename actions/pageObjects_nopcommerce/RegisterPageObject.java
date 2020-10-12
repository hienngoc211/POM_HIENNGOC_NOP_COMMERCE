package pageObjects_nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs_nopcommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickToMale() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_CHECKBOX);
		clickToElement(driver, RegisterPageUI.GENDER_CHECKBOX);
	}

	public void inputToFirstName(String firstNameValue) {
		waitToElementVisible(driver, RegisterPageUI.FIRST_NAME);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitToElementVisible(driver, RegisterPageUI.LAST_NAME);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME, lastNameValue);
	}

	public void selectDateDropdown(String dayValue) {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		sendKeyToElement(driver, RegisterPageUI.DAY_DROPDOWN, dayValue);
		
	}

	public void selectMonthDropdown(String monthValue) {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		sendKeyToElement(driver, RegisterPageUI.MONTH_DROPDOWN, monthValue);
		
	}

	public void selectYearDropdown(String yearValue) {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		sendKeyToElement(driver, RegisterPageUI.YEAR_DROPDOWN, yearValue);
	}

	public void sendKeyToEmail(String emailValue) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL);
		sendKeyToElement(driver, RegisterPageUI.EMAIL, emailValue);
		
	}

	public void sendKeyToCompany(String companyValue) {
		waitToElementVisible(driver, RegisterPageUI.COMPANY);
		sendKeyToElement(driver, RegisterPageUI.COMPANY, companyValue);
	}

	public void sendKeyToPassword(String passwordValue) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD, passwordValue);
		
	}

	public void sendKeyToConfirmPassWord(String passwordValue) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, passwordValue);
	}

	public void clickToRegisterBtn() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMsg() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS);
		getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS); 
		
	}

	public HomePageObject clickToLogoutBtn() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}


}
