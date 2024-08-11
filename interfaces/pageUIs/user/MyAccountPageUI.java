package pageUIs.user;

public class MyAccountPageUI {
	public static final String CONFIRM_VALUE_FIRST_NAME = "xpath=//input[@id='FirstName']";
	public static final String CONFIRM_VALUE_LAST_NAME = "xpath=//input[@id='LastName']";
	public static final String CONFIRM_VALUE_EMAIL = "xpath=//input[@id='Email']";
	public static final String CLICK_RADIO_BUTTON_GENDER = "xpath=//input[@id='gender-male']";
	public static final String MSG_UPDATE_SUCCESSFULLY = "xpath=//p[contains(text(),'The customer info has been updated successfully.')]";
	
	// Dynamic
	public static final String DYNAMIC_SELECT_DATE_OF_BIRTH = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_MSG__SUCCESSFULLY = "xpath=//p[contains(text(),'%s')]";
	public static final String DYNAMIC_ADDRESS_INFO_SUCCESSFULLY ="xpath=//li[@class='%s' and text()='%s']";
}
