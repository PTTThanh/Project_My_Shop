package commons;

import org.openqa.selenium.WebDriver;

import pageObject.AddressesPageObject;
import pageObject.Admin_LoginPageObject;
import pageObject.ChangePasswordPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.MyProductReviewPageObject;
import pageObject.ProductNotebookPageObject;
import pageObject.RegisterPageObject;
import pageObject.RewardPointPageObject;
import pageObject.SearchPageObject;
import pageObject.ShoppingCartPageObject;
import pageObject.WishlistPageObject;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static MyAccountPageObject geMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPageObject(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}

	public static WishlistPageObject getWishlistPageObject(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static ShoppingCartPageObject getShoppingCartPageobject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	public static ProductNotebookPageObject getProductNotebookPageObject(WebDriver driver) {
		return new ProductNotebookPageObject(driver);
	}
	public static Admin_LoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new Admin_LoginPageObject(driver);
	}

}
