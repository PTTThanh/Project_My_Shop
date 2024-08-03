package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Admin_CustomerPageUI;

public class Admin_CustomerPageObject extends BasePage {
	WebDriver driver;

	public Admin_CustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomer() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_CUSTOMER);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_TO_CUSTOMER);
	}

	public void clickToAddNewCustomer() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_ADD_NEW);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_TO_ADD_NEW);
	}

	public void clickGender() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_GENDER_RADIO_BUTTON);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_TO_GENDER_RADIO_BUTTON);
	}

	public void clickDeleteRole() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_DELETE_CUSTOMER_ROLE);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_TO_DELETE_CUSTOMER_ROLE);
	}

	public void selectCustomerRole(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_CustomerPageUI.CLICK_TO_CUSTOMER_ROLE);
		sendKeyToElement(driver,Admin_CustomerPageUI.INPUT_VALUE_CUSTOMER_ROLE , value);
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_VALUE_CUSTOMER_ROLE);
		clickToElement(driver,  Admin_CustomerPageUI.CLICK_TO_VALUE_CUSTOMER_ROLE);
	}

	public void inputAdminCommentTexteara(String string) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_CustomerPageUI.INPUT_AREA_ADMIN_COMMENT);
		sendKeyToElement(driver, Admin_CustomerPageUI.INPUT_AREA_ADMIN_COMMENT, string);
	}

	public void clickSaveButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_SAVE_BUTTON);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_SAVE_BUTTON);
	}

	public void selectCustomerRoleSearch(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_CustomerPageUI.CLICK_CUSTOMER_ROLES_SEARCH);
		sendKeyToElement(driver,Admin_CustomerPageUI.INPUT_CUSTOMER_ROLES_SEARCH , value);
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_VALUE_CUSTOMER_ROLE_SEARCH);
		clickToElement(driver,  Admin_CustomerPageUI.CLICK_TO_VALUE_CUSTOMER_ROLE_SEARCH);
	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_CustomerPageUI.CLICK_TO_SEARCH_BUTTON);
		clickToElement(driver, Admin_CustomerPageUI.CLICK_TO_SEARCH_BUTTON);
	}

	public void selectMonth(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_CustomerPageUI.SELECT_MONTH_OF_DATE_OF_BIRTH);
		selectByIndex(driver, Admin_CustomerPageUI.SELECT_MONTH_OF_DATE_OF_BIRTH, value);
	}

	public void selectDay(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_CustomerPageUI.SELECT_DAY_OF_DATE_OF_BIRTH);
		selectByIndex(driver, Admin_CustomerPageUI.SELECT_DAY_OF_DATE_OF_BIRTH, value);
	}
	
}
