package pageUI;

public class SearchPageUI {
	public static final String SEARCH_BUTTON = "//div[@class='search-input']//button[text()='Search']";
	public static final String MESSAGE_SEARCH_EMPTY_DATA = "//div[contains(text(),'Search term minimum length is 3 characters')]";
	public static final String MESSAGE_SEARCH_NOT_EXSIT_DATA = "//div[contains(text(),'No products were found that matched your criteria.')]";
	public static final String GET_TEXT_PRODUCT_01 = "//div[@class='product-item']//a[text()='Lenovo IdeaCentre 600 All-in-One PC']";
	public static final String GET_TEXT_PRODUCT_02 = "//div[@class='product-item']//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String CHECK_BOX_ADVANCE_SEARCH = "//div[@class='form-fields']//input[@id='advs']";
	public static final String CHOOSE_CATEGORIES = "//div[@id='advanced-search-block']//select[@id='cid']";
	public static final String CHECK_BOX_SEARCH_SUB_CATEGORIES = "//div[@class='inputs reversed']//input[@id='isc']";
	public static final String GET_TEXT_PRODUCT_03 = "//div[@class='details']//a[text()='Apple MacBook Pro 13-inch']";
	public static final String CHOOSE_MANUFACTURER = "//div[@class='inputs']//select[@id='mid']";
	public static final String CHECK_BOX_SEARCH_PRODUCT_DESCRIPTION = "//div[@class='inputs reversed']//input[@id='isc']";
	public static final String INPUT_SEARCH ="//input[@id='q']";
}
