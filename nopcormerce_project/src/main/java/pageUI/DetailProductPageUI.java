package pageUI;

public class DetailProductPageUI {
	public static final String ADD_YOUR_REVIEW = "//a[contains(text(),'Add your review')]";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[contains(text(),'Submit review')]";
	public static final String REVIEW_TEXT_AREA = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String REVIEW_TEXT_TITLE = "//input[@id='AddProductReview_Title']";
	public static final String CHOOSE_PROCESSOR_DROP_DOWNLIST = "//div[@class='attributes']//select[@id='product_attribute_1']";
	public static final String CHOOSE_RAM_DROP_DOWNLIST = "//select[@id='product_attribute_2']";
	public static final String SELECT_HDD_400_GB = "//input[@id='product_attribute_3_7']";
	public static final String SELECT_HDD_320_GB = "//input[@id='product_attribute_3_6']";
	public static final String SELECT_OS_VISTA_PRENIUM = "//input[@id='product_attribute_4_9']";
	public static final String SELECT_OS_VISTA_HOME = "//input[@id='product_attribute_4_8']";
	public static final String SELECT_SORTWARE_10 = "//input[@id='product_attribute_5_11']";
	public static final String SELECT_SORTWARE_5 = "//input[@id='product_attribute_5_12']";
	public static final String CLICK_ADD_TO_CART = "//div[@class='add-to-cart']//button[text()='Add to cart']";
	public static final String CLICK_UPDATE_BUTTON = "//div[@class='add-to-cart']//button[text()='Update']";
	public static final String VERIFY_MESSAGE_ADD_SUCCESSFULLY = "//div[@id='bar-notification']//p[contains(text(),'The product has been added to your ')]";
	public static final String CLICK_TO_CLOSE_ICON = "//div[@class='bar-notification success']//span[@class='close']";
	public static final String CLICK_TO_SHOPPING_LINK = "//div[@class='header-links']//a//span[contains(text(),'Shopping cart')]";
	public static final String VERIFY_COUNT_ITEMS = "//div[@class='count']//a[text()='1 item(s)']";
	public static final String INPUT_NUMBER_ITEM ="//div[@class='add-to-cart']//input[@id='product_enteredQuantity_1']";
	public static final String INOUT_UPDATE_BUTTON ="//button[@id='add-to-cart-button-1']";
	public static final String PRICE_BEFORE_UPADTE = "//div[@class='product-price']//span[@id='price-value-1']";
	public static final String PRICE_AFTER_UPDATE = "//div[@class='totals' and text()='Sub-Total: ']//strong[text()='$2,640.00']";
	public static final String CLICK_LENOVO_NAME = "//div[@class='details']//a['Lenovo IdeaCentre 600 All-in-One PC']";
}
