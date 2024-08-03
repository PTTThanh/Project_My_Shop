package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT);
	}

	public void clickToAddWishlistButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public Object getTextAddWishlist() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, WishlistPageUI.MESSAGE_ADD_WISHLIST_SUCCESSFULLY);
		return getElementText(driver, WishlistPageUI.MESSAGE_ADD_WISHLIST_SUCCESSFULLY);
	}

	public void clickToCloseButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_CLOSE_BUTTON);
		clickToElement(driver, WishlistPageUI.CLICK_CLOSE_BUTTON);
	}

	public void clickToWishlistLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, WishlistPageUI.CLICK_WISHLIST_LINK);
		clickToElement(driver, WishlistPageUI.CLICK_WISHLIST_LINK);
	}

	public Object getTextVerifyNameProduct() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, WishlistPageUI.TEXT_PRODUCT_AT_VERIFY_WISHLIST);
		return getElementText(driver, WishlistPageUI.TEXT_PRODUCT_AT_VERIFY_WISHLIST);
	}

	public void clickURLForSharing() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_URL_FOR_SHARING);
		clickToElement(driver, WishlistPageUI.CLICK_URL_FOR_SHARING);
	}

	public void clickToCheckBoxProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECK_BOX);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECK_BOX);
	}

	public void clickToAddToCartButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}

	public ShoppingCartPageObject clickToShoppingCartLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, WishlistPageUI.CLICK_SHOPPING_CART_LINK);
		clickToElement(driver, WishlistPageUI.CLICK_SHOPPING_CART_LINK);
		return new ShoppingCartPageObject(driver);
	}

	public Object getTextEmptyWishlist() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, WishlistPageUI.GET_TEXT_EMPTY_WISHLIST);
		return getElementText(driver, WishlistPageUI.GET_TEXT_EMPTY_WISHLIST);
	}

	public void clickToComputerMenu() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_COMPUTERS_MENU);
		clickToElement(driver, WishlistPageUI.CLICK_COMPUTERS_MENU);
	}

	public void clickToItemNotebook() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_ITEM_NOTEBOOK_OF_COMPUTER);
		clickToElement(driver, WishlistPageUI.CLICK_ITEM_NOTEBOOK_OF_COMPUTER);
	}

	public void clickToNameProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT_LIST);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT_LIST);
	}

	public void clickToRemove() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_REMOVE_ITEMS);
		clickToElement(driver, WishlistPageUI.CLICK_REMOVE_ITEMS);
	}

	public void clickToNameProduct1Comapre() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_1);
		clickToElement(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_1);
	}

	public void clickToNameProduct2Compare() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_2);
		clickToElement(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_2);
	}
	
	public void clickComapreProductList() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_LIST);
		clickToElement(driver, WishlistPageUI.CLICK_COMPARE_PRODUCT_LIST);
	}

	public Object verifyAddCompareSucessfully() {
		waitToElementVisible(driver, WishlistPageUI.MESSAGE_ADD_WISHLIST_SUCCESSFULLY);
		return getElementText(driver, WishlistPageUI.MESSAGE_ADD_WISHLIST_SUCCESSFULLY);
	}

	public void clickToClearList() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_CLEAR_LIST);
		clickToElement(driver, WishlistPageUI.CLICK_CLEAR_LIST);
	}

	public Object verifyEmptyCompare() {
		waitToElementVisible(driver, WishlistPageUI.VERIFY_EMPTY_COMPARE);
		return getElementText(driver, WishlistPageUI.VERIFY_EMPTY_COMPARE);
	}

	public void clickProductApple() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT);
	}

	public void clickProductAsus() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT_ASUS);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT_ASUS);
	}

	public void clickProductHPSleekbook() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT_HP);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT_HP);
	}

	public void clickProductHPUltrabook() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT_HP_ULTRABOOK);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT_HP_ULTRABOOK);
	}

	public void clickProductLenovo() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, WishlistPageUI.CLICK_NAME_PRODUCT_LENEVO);
		clickToElement(driver, WishlistPageUI.CLICK_NAME_PRODUCT_LENEVO);
	}
	

}
