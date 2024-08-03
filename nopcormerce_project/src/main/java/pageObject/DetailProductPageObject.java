package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.DetailProductPageUI;

public class DetailProductPageObject extends BasePage {
	WebDriver driver;

	public DetailProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddYourReview() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, DetailProductPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, DetailProductPageUI.ADD_YOUR_REVIEW);
	}

	public void clickToSubmitReviewButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, DetailProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, DetailProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public void inputTextAreaRevieText(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.REVIEW_TEXT_AREA);
		sendKeyToElement(driver,DetailProductPageUI.REVIEW_TEXT_AREA , value);
	}

	public void inputTitleReview(String review) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.REVIEW_TEXT_TITLE);
		sendKeyToElement(driver,DetailProductPageUI.REVIEW_TEXT_TITLE, review);
	}

	public void chooseProcessorDropdownList(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.CHOOSE_PROCESSOR_DROP_DOWNLIST);
		selectVisibleText(driver, DetailProductPageUI.CHOOSE_PROCESSOR_DROP_DOWNLIST, value);
	}

	public void chooseRamDropdownList(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.CHOOSE_RAM_DROP_DOWNLIST);
		selectVisibleText(driver, DetailProductPageUI.CHOOSE_RAM_DROP_DOWNLIST, value);
	}

	public void selectHDDRadioButton() {
		
		waitToElementVisible(driver, DetailProductPageUI.SELECT_HDD_400_GB);
		clickToElement(driver, DetailProductPageUI.SELECT_HDD_400_GB);
	}

	public void selectOSRadioButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.SELECT_OS_VISTA_PRENIUM);
		clickToElement(driver, DetailProductPageUI.SELECT_OS_VISTA_PRENIUM);
	}
	public void selectSorfwareCheckbox() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.SELECT_SORTWARE_10);
		checkToCheckbox(driver, DetailProductPageUI.SELECT_SORTWARE_10);
		waitToElementVisible(driver, DetailProductPageUI.SELECT_SORTWARE_5);
		checkToCheckbox(driver, DetailProductPageUI.SELECT_SORTWARE_5);
	}

	public void clickAddtoCart() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, DetailProductPageUI.CLICK_ADD_TO_CART);
		clickToElement(driver, DetailProductPageUI.CLICK_ADD_TO_CART);
	}

	public Object verifyAddProductSuccessfully() {
		waitToElementVisible(driver, DetailProductPageUI.VERIFY_MESSAGE_ADD_SUCCESSFULLY);
		return getElementText(driver, DetailProductPageUI.VERIFY_MESSAGE_ADD_SUCCESSFULLY);
	}

	public void clickToIconClose() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, DetailProductPageUI.CLICK_TO_CLOSE_ICON);
		clickToElement(driver, DetailProductPageUI.CLICK_TO_CLOSE_ICON);
	}

//	public ShoppingCartPageObject clickToCartLink() {
//		// TODO Auto-generated method stub
//		waitToElementClickable(driver, DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
//		clickToElement(driver, DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
//		return new ShoppingCartPageObject(driver) ;
//	}

	public void hoverClickShopping() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
		hoverClickToElement(driver, DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
		
	}

	public Object verifyCountItem() {
		waitToElementVisible(driver, DetailProductPageUI.VERIFY_COUNT_ITEMS);
		return getElementText(driver, DetailProductPageUI.VERIFY_COUNT_ITEMS);
	}

	public ShoppingCartPageObject clickToCartLink() {
		waitToElementClickable(driver, DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
		clickToElement(driver,  DetailProductPageUI.CLICK_TO_SHOPPING_LINK);
		return new ShoppingCartPageObject(driver);
	}

	public void selectHDDRadioButton320GB() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.SELECT_HDD_320_GB);
		clickToElement(driver, DetailProductPageUI.SELECT_HDD_320_GB);
	}

	public void selectOSRadioButtonHome() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.SELECT_OS_VISTA_HOME);
		clickToElement(driver, DetailProductPageUI.SELECT_OS_VISTA_HOME);
	}

	public void uncheckSorfware() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.SELECT_SORTWARE_10);
		uncheckToCheckbox(driver, DetailProductPageUI.SELECT_SORTWARE_10);
		waitToElementVisible(driver, DetailProductPageUI.SELECT_SORTWARE_5);
		uncheckToCheckbox(driver, DetailProductPageUI.SELECT_SORTWARE_5);
		
	}

	public void inputNumberItem(String number) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.INPUT_NUMBER_ITEM);
		sendKeyToElement(driver, DetailProductPageUI.INPUT_NUMBER_ITEM, number);
	}

	public void clickToUpdateButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.CLICK_UPDATE_BUTTON);
		clickToElement(driver, DetailProductPageUI.CLICK_UPDATE_BUTTON);
	}

	public Object verifyPriceBeforeUpdate() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.PRICE_BEFORE_UPADTE);
		return getElementText(driver, DetailProductPageUI.PRICE_BEFORE_UPADTE);
	}

	public Object verifyPriceAfterUpdate() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.PRICE_AFTER_UPDATE);
		return getElementText(driver, DetailProductPageUI.PRICE_AFTER_UPDATE);
	}

	public void clickToLenovo() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, DetailProductPageUI.CLICK_LENOVO_NAME);
		clickToElement(driver, DetailProductPageUI.CLICK_LENOVO_NAME);
	}

	

}
