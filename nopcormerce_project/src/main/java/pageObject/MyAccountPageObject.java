package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSaveButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, MyAccountPageUI.SAVE_BUTTON_MY_ACCOUNT);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON_MY_ACCOUNT);
	}

	public Object gettTextEditSuccess() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, MyAccountPageUI.MESSAGE_UPDATE_SUCCESSFULL);
		return getElementText(driver, MyAccountPageUI.MESSAGE_UPDATE_SUCCESSFULL);
	}

	public AddressesPageObject clickAdressLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, MyAccountPageUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_LINK);
		return new AddressesPageObject(driver);
	}

	public void inputFirstName(String fName) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, MyAccountPageUI.INPUT_FIRST_NAME);
		sendKeyToElement(driver, MyAccountPageUI.INPUT_FIRST_NAME, fName);
	}

	public void inputLastName(String lName) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, MyAccountPageUI.INPUT_FIRST_NAME);
		sendKeyToElement(driver, MyAccountPageUI.INPUT_FIRST_NAME, lName);
	}

}
