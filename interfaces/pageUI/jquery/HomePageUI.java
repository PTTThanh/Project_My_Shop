package pageUI.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BY_NAME ="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_LINK_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_LINK_ACTIVATE_BY_NUMBER ="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String ROW_ACTION_BY_COLUMN_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-remove-row-btn']";
	public static final String ALL_PAGE_LINKS ="xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//div[text()='%s']/ancestor::th/precesing-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr/td[%s]";
	
	public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
	public static final String DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
	public static final String DYNAMIC_CHECKOX_BY_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";
}
