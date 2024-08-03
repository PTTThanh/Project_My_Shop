package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.AddressPageUI;

public class AddressPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AddressPageUI.TEXT_TILE);
		return getTextElement(driver, AddressPageUI.TEXT_TILE);
		
	}

	
	

}
