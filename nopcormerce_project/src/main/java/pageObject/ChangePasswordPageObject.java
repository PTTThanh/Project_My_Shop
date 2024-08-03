package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePasswordButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public Object getTextChangePass() {
		waitToElementVisible(driver,ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		return getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON) ;
	}

	public void clickToCloseIcon() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ChangePasswordPageUI.CLICK_CLOSE_ICON);
		clickToElement(driver, ChangePasswordPageUI.CLICK_CLOSE_ICON);
	}
	public void clickToLogOut() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ChangePasswordPageUI.LOG_OUT_LINK);
		clickToElement(driver, ChangePasswordPageUI.LOG_OUT_LINK);
	}

	public void inputOldPassword(String oldPassword) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ChangePasswordPageUI.INPUT_OLD_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.INPUT_OLD_PASSWORD, oldPassword);
	}

	public void inputConfirmPassword(String newPassword) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ChangePasswordPageUI.INPUT_NEW_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.INPUT_NEW_PASSWORD, newPassword);
	}

	public void inputNewPassword(String confirmPassword) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ChangePasswordPageUI.INPUT_CONFIRM_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.INPUT_CONFIRM_PASSWORD, confirmPassword);
	}

}
