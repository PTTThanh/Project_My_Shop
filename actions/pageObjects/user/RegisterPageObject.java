package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getFirstNameErrorMassage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getTextElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
	}

	public String getLastNameErrorMassage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getTextElement(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailErrorMassage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPassowrdErrorMassage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	}

	public HomePageObject clickLogoNopCommerce() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.LOGO_URL);
		clickToElement(driver, RegisterPageUI.LOGO_URL);
		return PageGenerator.getHomePageObject(driver);
	}

	public void inputFirstName(String fName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.FRIST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FRIST_NAME_TEXTBOX, fName);
	}

	public void inputLastName(String lName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lName);
	}

	public void inputEmail(String email) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPassword(String confirmPass) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.COMFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMFIRM_PASSWORD_TEXTBOX, confirmPass);
	}
	//NOT UPDATE NEW 

	public String getRegisterSuccessful() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MSG);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MSG);
	}

	public String getConfirmPasswordNotMatchPassword() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	}

	public HomePageObject clickToLinkLogOut() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.LOG_OUT_LINK);
		clickToElement(driver, RegisterPageUI.LOG_OUT_LINK);
		return PageGenerator.getHomePageObject(driver);
	}

	

}
