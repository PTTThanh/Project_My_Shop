package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ChangePasswordPageUI;
import pageUI.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSeachButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public Object getTextSearchEmptyData() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.MESSAGE_SEARCH_EMPTY_DATA);
		return getElementText(driver, SearchPageUI.MESSAGE_SEARCH_EMPTY_DATA);
	}

	public Object getTextSearchNotExistData() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.MESSAGE_SEARCH_NOT_EXSIT_DATA);
		return getElementText(driver, SearchPageUI.MESSAGE_SEARCH_NOT_EXSIT_DATA);
	}

	public Object getTextProduct01() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.GET_TEXT_PRODUCT_01);
		return getElementText(driver, SearchPageUI.GET_TEXT_PRODUCT_01);
	}
	public Object getTextProduct02() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.GET_TEXT_PRODUCT_02);
		return getElementText(driver, SearchPageUI.GET_TEXT_PRODUCT_02);
	}

	public void checkBoxAdvancedSearch() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.CHECK_BOX_ADVANCE_SEARCH);
		checkToCheckbox(driver, SearchPageUI.CHECK_BOX_ADVANCE_SEARCH);
	}

	public void chooseCategory(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.CHOOSE_CATEGORIES);
		selectByIndex(driver, SearchPageUI.CHOOSE_CATEGORIES, value);
	}

	public void checkSearchSubCategories() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.CHECK_BOX_SEARCH_SUB_CATEGORIES);
		checkToCheckbox(driver, SearchPageUI.CHECK_BOX_SEARCH_SUB_CATEGORIES);
	}

	public Object getTextProduct3() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.GET_TEXT_PRODUCT_03);
		return getElementText(driver, SearchPageUI.GET_TEXT_PRODUCT_03);
	}

	public void chooseManufactures(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.CHOOSE_MANUFACTURER);
		selectByIndex(driver, SearchPageUI.CHOOSE_MANUFACTURER, value);
	}

	public void checkSearchInProductDescroption() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.CHECK_BOX_SEARCH_PRODUCT_DESCRIPTION);
		checkToCheckbox(driver, SearchPageUI.CHECK_BOX_SEARCH_PRODUCT_DESCRIPTION);
	}

	public void inputSearchName(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, SearchPageUI.INPUT_SEARCH);
		sendKeyToElement(driver, SearchPageUI.INPUT_SEARCH, value);
	}

}
