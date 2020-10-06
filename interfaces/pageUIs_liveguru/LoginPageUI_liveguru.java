package pageUIs_liveguru;

public class LoginPageUI_liveguru {
	public static final String EMAIL_TEXTBOX = "//input[@id='email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='pass']";
	public static final String LOGIN_BUTTON = "//button[@id='send2']";	
	public static final String ERROR_MESSAGE = "//div[@id='advice-required-entry-email' and text()='%s']";
	public static final String ERROR_MESSAGE_PASS = "//div[@id='advice-required-entry-pass' and text()='%s']";
	public static final String ERROR_MESSAGE_INVALID_EMAIL = "//div[@id='advice-validate-email-email' and text()='%s']";
	public static final String ERROR_MESSAGE_NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD = "//li[@class='error-msg']//span[contains(text(),'%s')]";
	public static final String PASSWORD_LESS_THAN_6_CHARACTERS = "//div[@id='advice-validate-password-pass'and text()='%s']";
}
