package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.OrderPageUI;

public class OrderPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.TEXT_TITLE_ORDER);
		return getTextElement(driver, OrderPageUI.TEXT_TITLE_ORDER);
	}

	
}
