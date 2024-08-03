package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}
	
	
	public String getExsitingEmailMessage() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.EMAIL_EXSITED_IN_SYSTEM);
		return getElementText(driver, RegisterPageUI.EMAIL_EXSITED_IN_SYSTEM);
	}

	public HomePageObject clickToContinuteButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, RegisterPageUI.CONTINUTE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUTE_BUTTON);
		return new HomePageObject(driver);
	}

	public Object verifyErrorMessageFirstName() {
		waitToElementVisible(driver, RegisterPageUI.FIRST_NAME_BLANK_TEXT);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_BLANK_TEXT);
	}

	public Object verifyErrorMessageLastName() {
		waitToElementVisible(driver, RegisterPageUI.LAST_NAME_BLANK_TEXT);
		return getElementText(driver, RegisterPageUI.LAST_NAME_BLANK_TEXT);
	}

	public Object verifyErrorMessageEmail() {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_BLANK_TEXT);
		return getElementText(driver, RegisterPageUI.EMAIL_BLANK_TEXT);
	}

	public Object verifyErrorMessagePassword() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_BLANK_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_BLANK_TEXT);
	}

	public Object verifyErrorMessageConfirmPassword() {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_BLANK_TEXT);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_BLANK_TEXT);
	}
	public Object verifyErrorMessageWrongEmail() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.WRONG_EMAIL_TEXT);
		return getElementText(driver, RegisterPageUI.WRONG_EMAIL_TEXT);
	}

	public Object verifyRefisteSuccessfully() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_TEXT);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_TEXT);
	}

	public Object verifyConfirmPasswordNotMatchPassword() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_NOT_MATCH_PASSWORD);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_NOT_MATCH_PASSWORD);
	}

}
