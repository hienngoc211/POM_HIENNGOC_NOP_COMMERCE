package commons;

import org.openqa.selenium.WebDriver;

import pageObjects_nopcommerce.FooterMyAccountPageObject;
import pageObjects_nopcommerce.FooterNewProductsPageObject;
import pageObjects_nopcommerce.FooterSearchPageObject;
import pageObjects_nopcommerce.HomePageObject;
import pageObjects_nopcommerce.LoginPageObject;
import pageObjects_nopcommerce.RegisterPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}

	public static FooterNewProductsPageObject getFooterNewProductsPageObject(WebDriver driver) {
		return new FooterNewProductsPageObject(driver);
	}
	
	public static FooterSearchPageObject getFooterSearchPageObject(WebDriver driver) {
		return new FooterSearchPageObject(driver)
;	}
}
