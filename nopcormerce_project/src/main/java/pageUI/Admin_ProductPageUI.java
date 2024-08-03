package pageUI;

public class Admin_ProductPageUI {
	public static final String INPUT_PRODUCT_NAME  = "//div[@class='col-md-5']//input[@id='SearchProductName']";
	public static final String CLICK_SEARCH_BUTTON ="//button[@id='search-products']";
	public static final String CLICK_CATEGORY_DROPDOWNLIST ="//select[@id='SearchCategoryId']";
	public static final String CHECK_BOX_SEARCH_SUBCATEGORIES ="//input[@id='SearchIncludeSubCategories']";
	public static final String VERIFY_NOT_EMPTY_DATA ="//tbody//tr//td[contains(text(),'No data available in table')]";
	public static final String CLICK_MANUFACTURE_DROPDOWNLIST ="//select[@id='SearchManufacturerId']";
	public static final String CLICK_GO_BUTTON ="//button[@id='go-to-product-by-sku']";
	public static final String VERIFY_PRODUCT_DETAIL ="//form[@id='product-form']//h1[@class='float-left']";
	public static final String VERIFY_NAME_PRODUCT ="//input[@id='Name']";
	public static final String CLICK_TO_BACK_LIST ="//a[normalize-space()='back to product list']";
	public static final String CLICK_TO_CUSTOMER_MENU ="//a[@href='#']//p[contains(text(),'Customers')]";
	
}
