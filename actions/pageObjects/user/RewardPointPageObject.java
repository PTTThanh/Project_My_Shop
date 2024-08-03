package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.RewardPointPageUI;

public class RewardPointPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RewardPointPageUI.TEXT_TITLE);
		return getTextElement(driver, RewardPointPageUI.TEXT_TITLE);
	}

	
	

}
