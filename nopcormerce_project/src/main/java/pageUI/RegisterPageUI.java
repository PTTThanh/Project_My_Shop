package pageUI;

public class RegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String FIRST_NAME_BLANK_TEXT = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_BLANK_TEXT = "//span[@id='LastName-error']";
	public static final String EMAIL_BLANK_TEXT ="//span[@id='Email-error']";
	public static final String PASSWORD_BLANK_TEXT="//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_BLANK_TEXT="//span[@id='ConfirmPassword-error']";
	public static final String WRONG_EMAIL_TEXT = "//span[@id='Email-error']";
	public static final String REGISTER_SUCCESSFULLY_TEXT = "//div[text() ='Your registration completed']";
	public static final String CONTINUTE_BUTTON = "//a[text()='Continue']";
	public static final String EMAIL_EXSITED_IN_SYSTEM ="//li[contains(text(),'The specified email already exists')]";
	public static final String CONFIRM_PASSWORD_NOT_MATCH_PASSWORD ="//span[@class='field-validation-error']//span[@id='ConfirmPassword-error']";
}
