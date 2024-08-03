package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.AddressPageUI;

public class AddressesPageObject extends BasePage {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSaveButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	public void selectCountry(String value) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, AddressPageUI.COUNTRY_DROPDOWNLIST);
		selectItemDropdown(driver, AddressPageUI.COUNTRY_DROPDOWNLIST, value);
	}

	public void clickToAddNew() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
	}

	public Object getTextAddAddress() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.TEXT_MESSAGE_ADD_ADDRESS_SUCCESSFULLY);
		return getElementText(driver, AddressPageUI.TEXT_MESSAGE_ADD_ADDRESS_SUCCESSFULLY);
	}

	public ChangePasswordPageObject clickChangePassword() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, AddressPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AddressPageUI.CHANGE_PASSWORD_LINK);
		return new ChangePasswordPageObject(driver);
	}

	public void inputFirstNameAddress(String fName) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_FIRST_NAME);
		sendKeyToElement(driver, AddressPageUI.INPUT_FIRST_NAME, fName);
	}

	public void inputEmailAddress(String email) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_EMAIL);
		sendKeyToElement(driver, AddressPageUI.INPUT_EMAIL, email);
	}

	public void inputLastNameAddress(String lName) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_LAST_NAME);
		sendKeyToElement(driver, AddressPageUI.INPUT_LAST_NAME, lName);
	}

	public void inputAddress(String address) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver,AddressPageUI.INPUT_ADDRESS_1);
		sendKeyToElement(driver, AddressPageUI.INPUT_ADDRESS_1, address);
	}

	public void inputCityAddress(String city) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_CITY);
		sendKeyToElement(driver, AddressPageUI.INPUT_CITY, city);
	}

	public void inputZipPostalCodeAddress(String zip) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_ZIP_CODE);
		sendKeyToElement(driver, AddressPageUI.INPUT_ZIP_CODE, zip);
	}

	public void inputPhoneNumberAddress(String phone) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, AddressPageUI.INPUT_PHONE_NUMBER);
		sendKeyToElement(driver, AddressPageUI.INPUT_PHONE_NUMBER, phone);
	}

}
