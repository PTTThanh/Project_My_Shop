package pageObject.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputColumnTextByName(String columnName, String value) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, value, columnName);
	}

	public void clickToPageByNumber(String numberPage) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, numberPage);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, numberPage);
	}

	public boolean isPageActiveByNumber(String numberPage) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVATE_BY_NUMBER, numberPage);
		return isControlDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVATE_BY_NUMBER, numberPage);
	}

	public void clickToRowActionByCountryName(String nameCountry) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COLUMN_NAME, nameCountry);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COLUMN_NAME, nameCountry);
	}

	public void getAllPageValueByColumnName(String columName) {
		List<String> allValues = new ArrayList<String>();
		// Bước 1: Lấy ra tất cả các page
		List<WebElement> allPageLinks = getElements(driver, HomePageUI.ALL_PAGE_LINKS);
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME,columName)+1;
		// Bước 2: Duyệt qua từng page
		for(WebElement pageLink:allPageLinks) {
			pageLink.click();
		}
		// Bước 3: Lấy ra tất cả các giá trị của 1 cột trong các page đó -> lưu vào
		// list/set
		List<WebElement> allRowValues = getElements(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX,String.valueOf(columnIndex));
		// Bước 4: Duyệt hết các page
		for(WebElement rowValue:allRowValues) {
			allValues.add(rowValue.getText());
		}

	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueTosend) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)+1;
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex ,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX, valueTosend, rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)+1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX,rowIndex ,String.valueOf(columnIndex));
		selectVisibleText(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex ,String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName,String rowIndex) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)+1;
		waitForElementClickable(driver,HomePageUI.DYNAMIC_CHECKOX_BY_INDEX_AND_COLUMN_INDEX , rowIndex ,String.valueOf(columnIndex));
		checkTheCheckboxOrRadio(driver, HomePageUI.DYNAMIC_CHECKOX_BY_INDEX_AND_COLUMN_INDEX,rowIndex ,String.valueOf(columnIndex));
	}
}
