package com.nopcormerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Common_Resgister_Login;
import commons.PageGeneratorManager;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.ShoppingCartPageObject;
import pageObject.WishlistPageObject;

public class Nop_06_Wishlist_Compare_RecentView extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private WishlistPageObject wishlistPage;
	private ShoppingCartPageObject shoppingCartPage;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.userLoginPage(Common_Resgister_Login.email, Common_Resgister_Login.password);
	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		wishlistPage = PageGeneratorManager.getWishlistPageObject(driver);
		wishlistPage.clickToProduct();
		wishlistPage.clickToAddWishlistButton();
		verifyEquals(wishlistPage.getTextAddWishlist(), "The product has been added to your wishlist");
		wishlistPage.clickToCloseButton();
		wishlistPage.sleepInSecond(2);
		wishlistPage.clickToWishlistLink();
		verifyEquals(wishlistPage.getTextVerifyNameProduct(), "Apple MacBook Pro 13-inch");
		wishlistPage.clickURLForSharing();
	}

	@Test
	public void TC_02_Add_Product_Cart_From_Wishlist_Page() {
		wishlistPage.clickToWishlistLink();
		wishlistPage.clickToCheckBoxProduct();
		wishlistPage.clickToAddToCartButton();
		wishlistPage.sleepInSecond(2);
		shoppingCartPage = wishlistPage.clickToShoppingCartLink();
		shoppingCartPage.sleepInSecond(2);
		verifyEquals(shoppingCartPage.getTextProductShoppingCart(), "Apple MacBook Pro 13-inch");
		shoppingCartPage.sleepInSecond(2);
		shoppingCartPage.clickToWishlistLink();
		shoppingCartPage.sleepInSecond(2);
		// verifyEquals(wishlistPage.getTextEmptyWishlist(), "The wishlist is empty!");

	}

	public void TC_03_Remove_Product_Wishlist_Page() {
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickToNameProduct();
		wishlistPage.sleepInSecond(2);
		wishlistPage.clickToAddWishlistButton();
		verifyEquals(wishlistPage.getTextAddWishlist(), "The product has been added to your wishlist");
		wishlistPage.clickToCloseButton();
		shoppingCartPage.sleepInSecond(2);
		shoppingCartPage.clickToWishlistLink();
		wishlistPage.clickToRemove();
		verifyEquals(wishlistPage.getTextEmptyWishlist(), "The wishlist is empty!");
		wishlistPage.sleepInSecond(2);
	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		// wishlistPage = PageGeneratorManager.getWishlistPageObject(driver);
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickToNameProduct();
		wishlistPage.clickToNameProduct1Comapre();
		// verifyEquals(wishlistPage.verifyAddCompareSucessfully(),"The product has been
		// added to your ");
		wishlistPage.clickToNameProduct2Compare();
		// verifyEquals(wishlistPage.verifyAddCompareSucessfully(),"The product has been
		// added to your ");
		wishlistPage.clickComapreProductList();
		wishlistPage.clickToClearList();
		verifyEquals(wishlistPage.verifyEmptyCompare(), "You have no items to compare.");

	}

	@Test
	public void TC_05_Recently_Viewed_Product() {
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickToNameProduct();
		wishlistPage.sleepInSecond(2);
		wishlistPage.clickProductApple();
		wishlistPage.sleepInSecond(5);
		wishlistPage.clickProductAsus();
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickProductHPSleekbook();
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickProductHPUltrabook();
		wishlistPage.clickToComputerMenu();
		wishlistPage.clickToItemNotebook();
		wishlistPage.clickProductLenovo();
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
