package pageUI;

public class Admin_CustomerPageUI {
	public static final String CLICK_TO_CUSTOMER = "//ul[@class='nav nav-treeview']//li//p[normalize-space()='Customers']";
	public static final String CLICK_TO_ADD_NEW = "//a[normalize-space()='Add new']";
	public static final String CLICK_TO_GENDER_RADIO_BUTTON = "//input[@id='Gender_Male']";
	public static final String CLICK_TO_DELETE_CUSTOMER_ROLE= "//ul[@id='SelectedCustomerRoleIds_taglist']//span[@title='delete']";
	public static final String CLICK_TO_CUSTOMER_ROLE= "//div[@class='input-group-append input-group-required']//div[@role='listbox']";
	public static final String SELECT_TO_CUSTOMER_ROLE= "//select[@id='SelectedCustomerRoleIds']";
	public static final String CLICK_TO_VALUE_CUSTOMER_ROLE= "//ul[@id='SelectedCustomerRoleIds_listbox']//li[normalize-space()='Guests']";
	public static final String INPUT_VALUE_CUSTOMER_ROLE = "//div[@class='input-group-append input-group-required']//input[@role='listbox']";
	public static final String INPUT_AREA_ADMIN_COMMENT= "//textarea[@id='AdminComment']";
	public static final String CLICK_SAVE_BUTTON= "//div[@class='float-right']//button[@name='save']";
	public static final String INPUT_CUSTOMER_ROLES_SEARCH ="//input[@role='listbox']";
	public static final String CLICK_CUSTOMER_ROLES_SEARCH ="//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String CLICK_TO_VALUE_CUSTOMER_ROLE_SEARCH= "//ul[@id='SelectedCustomerRoleIds_listbox']//li[contains(text(),'Guests')]";
	public static final String CLICK_TO_SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String SELECT_MONTH_OF_DATE_OF_BIRTH = "//select[@id='SearchMonthOfBirth']";
	public static final String SELECT_DAY_OF_DATE_OF_BIRTH = "//select[@id='SearchDayOfBirth']";
}
