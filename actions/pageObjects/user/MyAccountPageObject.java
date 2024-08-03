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

	
	

}
