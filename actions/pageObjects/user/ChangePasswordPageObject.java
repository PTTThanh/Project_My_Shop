package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.ChangePasswordPageUI;
import pageUIs.user.MyAccountPageUI;

public class ChangePasswordPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ChangePasswordPageUI.TEXT_TITLE_CHANGE_PASSWORD);
		return getTextElement(driver, ChangePasswordPageUI.TEXT_TITLE_CHANGE_PASSWORD);
	}

	public String msgChangePassSuccessful(String text) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ChangePasswordPageUI.DYNAMIC_MSG_CHANGE_PASS_SUCCESSFULLY,text);
		return getTextElement(driver, ChangePasswordPageUI.DYNAMIC_MSG_CHANGE_PASS_SUCCESSFULLY,text);
	}

	public void clickToCloseIcon() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,ChangePasswordPageUI.CLICK_TO_CLOSE_ICON);
		clickToElement(driver, ChangePasswordPageUI.CLICK_TO_CLOSE_ICON);
	}

	public HomePageObject clickToLogOut() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,ChangePasswordPageUI.CLICK_TO_LOG_OUT);
		clickToElement(driver, ChangePasswordPageUI.CLICK_TO_LOG_OUT);
		return new HomePageObject(driver);
	}

	
	

}
