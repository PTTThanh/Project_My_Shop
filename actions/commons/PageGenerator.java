package commons;

import org.openqa.selenium.WebDriver;

import pageObject.damin.AdminLoginPageObject;
import pageObject.damin.DashBoardPageObject;
import pageObjects.user.AddressPageObject;
import pageObjects.user.BackInStockSubscriptionsPagetObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.DownloadProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;
import pageObjects.user.UserLoginPageObject;

public class PageGenerator {
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static UserLoginPageObject getLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	public static AddressPageObject getAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	public static OrderPageObject getOrderPageObject(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	public static DownloadProductPageObject getDownloadProductPageObject(WebDriver driver) {
		return new DownloadProductPageObject(driver);
	}
	public static BackInStockSubscriptionsPagetObject getBackInStockSubscriptionsPagetObject(WebDriver driver) {
		return new BackInStockSubscriptionsPagetObject(driver);
	}
	public static RewardPointPageObject getRewardPointPageObject(WebDriver driver) {
		return new RewardPointPageObject (driver);
	}
	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject (driver);
	}
	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject (driver);
	}
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject (driver);
	}
	public static DashBoardPageObject getDashBoardPageObject(WebDriver driver) {
		return new DashBoardPageObject (driver);
	}
}
