package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.MyAccountPageUI;

public class MyAccountPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getValueFirstName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_VALUE_FIRST_NAME);
		return getAttributeValue(driver, MyAccountPageUI.CONFIRM_VALUE_FIRST_NAME, "value");
	}

	public String getValueLastName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_VALUE_LAST_NAME);
		return getAttributeValue(driver, MyAccountPageUI.CONFIRM_VALUE_LAST_NAME, "value");
	}

	public String getValueEmail() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_VALUE_EMAIL);
		return getAttributeValue(driver, MyAccountPageUI.CONFIRM_VALUE_EMAIL, "value");
	}

	public void clickRadioGender() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountPageUI.CLICK_RADIO_BUTTON_GENDER);
		checkTheCheckboxOrRadio(driver, MyAccountPageUI.CLICK_RADIO_BUTTON_GENDER);
	}

	public void selectDateOfBirth(String nameSelectDateOfBirth, String value) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_SELECT_DATE_OF_BIRTH, nameSelectDateOfBirth);
		selectByValue(driver, MyAccountPageUI.DYNAMIC_SELECT_DATE_OF_BIRTH, value, nameSelectDateOfBirth);
	}

	public String msgUpdateSuccessful(String text) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_MSG__SUCCESSFULLY,text);
		return getTextElement(driver, MyAccountPageUI.DYNAMIC_MSG__SUCCESSFULLY,text);
	}

	public String verifyInfoAdressSuccessfully(String textClass, String textvalue) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_MSG__SUCCESSFULLY,textClass,textvalue);
		return getTextElement(driver, MyAccountPageUI.DYNAMIC_MSG__SUCCESSFULLY,textClass,textvalue);
		
	}

	
	

}
