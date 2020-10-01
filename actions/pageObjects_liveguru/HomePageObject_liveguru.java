package pageObjects_liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs_liveguru.HomePageUI_liveguru;
import pageUIs_nopcommerce.HomePageUI;

public class HomePageObject_liveguru extends AbstractPages {
	private WebDriver driver;
	
	public HomePageObject_liveguru(WebDriver _driver) {
		driver = _driver;
	}

	public LoginPageObject_liveguru clickToMyAccountFooter() {
		waitToElementClickable(driver, HomePageUI_liveguru.MY_ACCOUNT_FOOTER);
		return new LoginPageObject_liveguru(driver);
	}
	
	
	
	
	


}
