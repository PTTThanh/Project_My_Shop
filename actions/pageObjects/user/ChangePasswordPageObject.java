package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.ChangePasswordPageUI;

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

	
	

}
