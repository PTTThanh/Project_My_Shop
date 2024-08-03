package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.BasePageUI;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddressPageObject clickToMenuAddress() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.CLICK_MENU_ADDRESS);
		clickToElement(driver, MyAccountSideBarPageUI.CLICK_MENU_ADDRESS);
		return PageGenerator.getAddressPageObject(driver);
	}

	public OrderPageObject clickToLinkOrder() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_MENU_ORDER);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_MENU_ORDER);
		return PageGenerator.getOrderPageObject(driver);
	}

	public DownloadProductPageObject clickToLinkDownloadProduct() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_DOWNLOAD_PRODUCT);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_DOWNLOAD_PRODUCT);
		return PageGenerator.getDownloadProductPageObject(driver);
	}

	public BackInStockSubscriptionsPagetObject clickToBackInStockSubscription() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_BACK_IN_STOCK_SUBCRIPTION);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_BACK_IN_STOCK_SUBCRIPTION);
		return PageGenerator.getBackInStockSubscriptionsPagetObject(driver);
	}

	public RewardPointPageObject clickToLinkRewardPoint() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_REWARD_POINT);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_REWARD_POINT);
		return PageGenerator.getRewardPointPageObject(driver);
	}

	public ChangePasswordPageObject clickToLinkChangePassword() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_CHANGE_PAASWORD);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_CHANGE_PAASWORD);
		return PageGenerator.getChangePasswordPageObject(driver);
	}

	public MyProductReviewPageObject clickToLinkMyProductReview() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountSideBarPageUI.LINK_MY_PRODUCT_REVIEW);
		clickToElement(driver, MyAccountSideBarPageUI.LINK_MY_PRODUCT_REVIEW);
		return PageGenerator.getMyProductReviewPageObject(driver);
	}

	public MyAccountSideBarPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CLICK_DYNAMIC_SIDEBAR_MENU, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.CLICK_DYNAMIC_SIDEBAR_MENU, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGenerator.getAddressPageObject(driver);

		case "Orders":
			return PageGenerator.getOrderPageObject(driver);

		case "Downloadable products":
			return PageGenerator.getDownloadProductPageObject(driver);
		case "Back in stock subscriptions":
			return PageGenerator.getBackInStockSubscriptionsPagetObject(driver);
		case "Reward points":
			return PageGenerator.getRewardPointPageObject(driver);
		case "Change password":
			return PageGenerator.getChangePasswordPageObject(driver);
		case "My product reviews":
			return PageGenerator.getMyProductReviewPageObject(driver);

		default:
			new RuntimeException("Not exsit pageName");
			return null;
		}
	}
	public void openDynamicSideBarPageByName(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CLICK_DYNAMIC_SIDEBAR_MENU, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.CLICK_DYNAMIC_SIDEBAR_MENU, pageName);
		}

}
