package pageUI;

public class ShoppingCartUI {
	public static final String GET_TEXT_NAME_PRODUCT_SHOPPING_CART = "//tbody//tr//td//a[@class='product-name' and text()='Apple MacBook Pro 13-inch']";
	public static final String CLICK_WISHLIST_LINK = "//div[contains(@class,'header-links')]//a[@class='ico-wishlist']//span[text()='Wishlist']";
	public static final String CLICK_TO_EDIT_LINK ="//div[@class='edit-item']//a[text()='Edit']";
	public static final String CLICK_TO_REMOVE_ICON ="//tbody//tr//td[@class='remove-from-cart']//button[@name='updatecart']";
	public static final String CLICK_UPDATE_SHOPPING_CART_BUTTON ="//div[@class='common-buttons']//button[@id='updatecart']";
	public static final String VERIFY_EMPTY_SHOPPING_CART ="//div[@class='order-summary-content']//div[contains(text(),'Your Shopping Cart is empty!')]";
	public static final String INPUT_KEY_WORD_SEARCH ="//div[@class='search-box store-search-box']//input[@id='small-searchterms']";
	public static final String CLICK_SEARCH_BUTTON ="//div[@class='search-box store-search-box']//button[@class='button-1 search-box-button']";
	public static final String INPUT_NUMBER_QUANLITY ="//tbody//tr//td[@class='quantity']//input[@id='itemquantity11228']";
	public static final String VERIFY_TOTAL_AFTER_UPDATE ="//tbody//tr//td[@class='subtotal']//span[@class='product-subtotal']";
}
