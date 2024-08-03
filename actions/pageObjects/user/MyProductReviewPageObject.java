package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyProductReviewPageUI.TEXT_MY_PRODUCT_REVIEW);
		return getTextElement(driver, MyProductReviewPageUI.TEXT_MY_PRODUCT_REVIEW);
	}
	

}
