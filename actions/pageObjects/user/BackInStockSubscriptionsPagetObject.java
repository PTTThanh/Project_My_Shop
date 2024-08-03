package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.BackInStockSubscriptionsPagetUI;

public class BackInStockSubscriptionsPagetObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public BackInStockSubscriptionsPagetObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, BackInStockSubscriptionsPagetUI.TEXT_TITLE_BACK_IN_STOCK_SUBSCRIPTION);
		return getTextElement(driver, BackInStockSubscriptionsPagetUI.TEXT_TITLE_BACK_IN_STOCK_SUBSCRIPTION);
	}

	

}
