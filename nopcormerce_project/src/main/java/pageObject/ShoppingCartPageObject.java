package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ShoppingCartUI;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getTextProductShoppingCart() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.GET_TEXT_NAME_PRODUCT_SHOPPING_CART);
		return getElementText(driver, ShoppingCartUI.GET_TEXT_NAME_PRODUCT_SHOPPING_CART);
	}

	public void clickToWishlistLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.CLICK_WISHLIST_LINK);
		clickToElement(driver, ShoppingCartUI.CLICK_WISHLIST_LINK);
	}

	public DetailProductPageObject clickToEditLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.CLICK_TO_EDIT_LINK);
		clickToElement(driver, ShoppingCartUI.CLICK_TO_EDIT_LINK);
		return new DetailProductPageObject(driver);
	}

	public void clickRemoveIcon() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.CLICK_TO_REMOVE_ICON);
		clickToElement(driver, ShoppingCartUI.CLICK_TO_REMOVE_ICON);
	}

	public void clickToUpdateShoppingCart() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.CLICK_UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartUI.CLICK_UPDATE_SHOPPING_CART_BUTTON);
	}

	public Object verifyMessageEmptyShoppingCart() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.VERIFY_EMPTY_SHOPPING_CART);
		return getElementText(driver, ShoppingCartUI.VERIFY_EMPTY_SHOPPING_CART);
	}

	public void inputKeyWordSearch(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.INPUT_KEY_WORD_SEARCH);
		sendKeyToElement(driver, ShoppingCartUI.INPUT_KEY_WORD_SEARCH, value);
	}

	public DetailProductPageObject clickSeachButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ShoppingCartUI.CLICK_SEARCH_BUTTON);
		clickToElement(driver, ShoppingCartUI.CLICK_SEARCH_BUTTON);
		return new DetailProductPageObject(driver);
	}

	public void inputQuanlity(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.INPUT_NUMBER_QUANLITY);
		sendKeyToElement(driver, ShoppingCartUI.INPUT_NUMBER_QUANLITY, value);
	}

	public Object verifyTotalAfterUpdate() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, ShoppingCartUI.VERIFY_TOTAL_AFTER_UPDATE);
		return getElementText(driver, ShoppingCartUI.VERIFY_TOTAL_AFTER_UPDATE);
	}



}
