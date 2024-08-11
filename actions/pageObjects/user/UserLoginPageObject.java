package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.BasePage;
import pageUIs.user.LoginPageUI;

public class UserLoginPageObject extends BaseElement {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		waitToElementPresence(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
		
	}

	public String getEmailErrorMgs() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_EMPTY_MSG);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_EMPTY_MSG);
	}

	public void inputEmail(String email) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXBOX, password);
	}

	

	public String getEmailNotRegisterErrorMgs() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_NOT_REGISTER_MSG);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_NOT_REGISTER_MSG);
	}

	

}
