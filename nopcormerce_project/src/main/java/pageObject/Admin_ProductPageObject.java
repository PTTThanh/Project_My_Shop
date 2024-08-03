package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Admin_ProductPageUI;

public class Admin_ProductPageObject extends BasePage {
	WebDriver driver;

	public Admin_ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputProductName(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_ProductPageUI.INPUT_PRODUCT_NAME);
		sendKeyToElement(driver, Admin_ProductPageUI.INPUT_PRODUCT_NAME, value);
	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_SEARCH_BUTTON);
		clickToElement(driver, Admin_ProductPageUI.CLICK_SEARCH_BUTTON);
	}

	public void selectCategory(String value) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_CATEGORY_DROPDOWNLIST);
		selectVisibleText(driver, Admin_ProductPageUI.CLICK_CATEGORY_DROPDOWNLIST, value);
	}

	public Object verifyEmptyNoData() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_ProductPageUI.VERIFY_NOT_EMPTY_DATA);
		return getElementText(driver, Admin_ProductPageUI.VERIFY_NOT_EMPTY_DATA);
	}

	public void clickToCheckBoxCategory() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CHECK_BOX_SEARCH_SUBCATEGORIES);
		checkToCheckbox(driver, Admin_ProductPageUI.CHECK_BOX_SEARCH_SUBCATEGORIES);
	}

	public void selectManufacture(String value) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_MANUFACTURE_DROPDOWNLIST);
		selectVisibleText(driver, Admin_ProductPageUI.CLICK_MANUFACTURE_DROPDOWNLIST, value);
	}

	public void clickToGoDirectlyProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_GO_BUTTON);
		clickToElement(driver, Admin_ProductPageUI.CLICK_GO_BUTTON);
	}

	public Object verifyPageProductDetail() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_ProductPageUI.VERIFY_PRODUCT_DETAIL);
		return getElementText(driver, Admin_ProductPageUI.VERIFY_PRODUCT_DETAIL);
	}

	public Object verifyNameProduct() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, Admin_ProductPageUI.VERIFY_NAME_PRODUCT);
		return getElementText(driver, Admin_ProductPageUI.VERIFY_NAME_PRODUCT);
	}

	public void clickBackToList() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_TO_BACK_LIST);
		clickToElement(driver, Admin_ProductPageUI.CLICK_TO_BACK_LIST);
	}

	public Admin_CustomerPageObject clickToCutomerMenu() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_ProductPageUI.CLICK_TO_CUSTOMER_MENU);
		clickToElement(driver, Admin_ProductPageUI.CLICK_TO_CUSTOMER_MENU);
		return new  Admin_CustomerPageObject(driver);
	}

	
	
}
