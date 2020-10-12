package pageObjects_liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs_liveguru.DashboardPageUI_liveguru;
import pageUIs_nopcommerce.RegisterPageUI;

public class DashboardPageObject_liveguru extends AbstractPages {
	private WebDriver driver;
	
	public DashboardPageObject_liveguru(WebDriver _driver) {
		driver = _driver;
	}

	public boolean isFullNameOrEmailDisplayed(String errorMsg) {
		waitToElementVisible(driver, String.format(DashboardPageUI_liveguru.EMAIL_PASSWORD_TEXT, errorMsg));
		return isElementDisplayed(driver, String.format(DashboardPageUI_liveguru.EMAIL_PASSWORD_TEXT, errorMsg));
	}

	
	


}
