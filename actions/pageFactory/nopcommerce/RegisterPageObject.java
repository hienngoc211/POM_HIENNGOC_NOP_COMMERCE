package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPagesFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='M']")
	private WebElement genderCheckbox;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	private WebElement dayDropdown;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	private WebElement monthDropdown;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	private WebElement yearDropdown;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Company']")
	private WebElement companyTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//input[@id='register-button']")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccess;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	
	public void clickToMale() {
		waitToElementClickable(driver, genderCheckbox );
		clickToElement(driver, genderCheckbox);
	}

	public void inputToFirstName(String firstNameValue) {
		waitToElementDisplayed(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitToElementDisplayed(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastNameValue);
	}

	public void selectDateDropdown(String dayValue) {
		waitToElementDisplayed(driver, dayDropdown);
		sendKeyToElement(driver, dayDropdown, dayValue);
		
	}

	public void selectMonthDropdown(String monthValue) {
		waitToElementDisplayed(driver, monthDropdown);
		sendKeyToElement(driver, monthDropdown, monthValue);
		
	}

	public void selectYearDropdown(String yearValue) {
		waitToElementDisplayed(driver, monthDropdown);
		sendKeyToElement(driver, monthDropdown, yearValue);
	}

	public void sendKeyToEmail(String emailValue) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailValue);
		
	}

	public void sendKeyToCompany(String companyValue) {
		waitToElementDisplayed(driver, companyTextbox);
		sendKeyToElement(driver, companyTextbox, companyValue);
	}

	public void sendKeyToPassword(String passwordValue) {
		waitToElementDisplayed(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, passwordValue);
		
	}

	public void sendKeyToConfirmPassWord(String passwordValue) {
		waitToElementDisplayed(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, passwordValue);
	}

	public void clickToRegisterBtn() {
		waitToElementClickable(driver, registerBtn);
		clickToElement(driver, registerBtn);
	}

	public String getRegisterSuccessMsg() {
		waitToElementDisplayed(driver, registerSuccess);
		getTextElement(driver, registerSuccess);
		return getTextElement(driver, registerSuccess); 
		
	}

	public HomePageObject clickToLogoutBtn() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		return new HomePageObject(driver);
	}


}
