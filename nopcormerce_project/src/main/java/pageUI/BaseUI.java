package pageUI;

public class BaseUI {
	//myProductReviewPage
	public static final String MY_PRODUCT_REVIEW_LINK = "//a[normalize-space()='My product reviews']";
	public static final String ADDRESS_LINK = "//li[@class='customer-addresses inactive']//a[normalize-space()='Addresses']";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account' and text() ='My account' ]";
	public static final String REWARD_POINT_LINK = "//a[@class='ico-account']//a[normalize-space()='Reward points']";
	public static final String DYNAMIC_MENU_PAGE_LINK = "//li[@class='customer-orders inactive']//a[normalize-space()='%s']";
	//Page Object
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_ID = "//input[@id='Name']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String COLUMN_INDEX_BY_NAME = "//tr//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody//tr[%s]//td[%s]";
	//
	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
}
