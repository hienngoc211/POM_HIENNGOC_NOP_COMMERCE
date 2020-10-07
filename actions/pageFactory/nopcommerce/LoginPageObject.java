package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPages;
import pageUIs_nopcommerce.LoginPageUI;

public class LoginPageObject extends AbstractPagesFactory {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
		
	public void sendKeyToEmailTextBox(String emailValue) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailValue);
	}

	public void sendKeyToPasswordTextBox(String passwordValue) {
		waitToElementDisplayed(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, passwordValue);
		
	}

	public HomePageObject clickToLoginBtn() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		return new HomePageObject(driver);
	}

}
