package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorNotRegisterMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.NOT_REGISTER_EMAIL_TEXTBOX);
		return getElementText(driver, LoginPageUI.NOT_REGISTER_EMAIL_TEXTBOX);
	}

	public String getErrorBlankPassMessageAtPasswordTextbox() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorWrongPassMessageAtPasswordTextbox() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_PASSWORD);
	}

	public HomePageObject userLoginPage(String email, String pass) {
		// TODO Auto-generated method stub
		inputEmail(email);
		inputPassword(pass);
		clickLoginButton();
		return new HomePageObject(driver);
	}

	public void clickLoginButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public Object verifyErrorMessageEmptyData() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_EMPTY_DATA);
		return getElementText(driver, LoginPageUI.LOGIN_EMPTY_DATA);
	}

	public void inputEmail(String email) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.INPUT_EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.INPUT_EMAIL_TEXTBOX, email);
	}

	public void inputPassword(String password) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.INPUT_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.INPUT_PASSWORD_TEXTBOX, password);
	}

	public Object verifyMessageWrongEmail() {
		waitToElementVisible(driver, LoginPageUI.WRONG_EMAIL_TEXTBOX);
		return getElementText(driver, LoginPageUI.WRONG_EMAIL_TEXTBOX);
	}

}
