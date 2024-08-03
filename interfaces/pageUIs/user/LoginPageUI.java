package pageUIs.user;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXBOX = "xpath=//input[@id='Password']";
	public static final String REMEMBER_CHECKBOX = "xpath=//input[@id='RememberMe']";
	public static final String FORGOT_PASSWORD_LINK = "xpath=//a[contains(text(),'Forgot password?')]";
	public static final String LOGIN_BUTTON = "xpath=//button[contains(text(),'Log in')]";
	public static final String EMAIL_ERROR_EMPTY_MSG = "xpath=//span[@id='Email-error']";
	public static final String EMAIL_ERROR_NOT_REGISTER_MSG = "xpath=//div[@class='message-error validation-summary-errors']";
}
