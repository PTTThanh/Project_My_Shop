package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Admin_DashboardUI;

public class Admin_DashboardPageObject extends BasePage {
	WebDriver driver;

	public Admin_DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCatalog() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_DashboardUI.CLICK_MENU_LINK_OF_CATALOG);
		clickToElement(driver, Admin_DashboardUI.CLICK_MENU_LINK_OF_CATALOG);
	}

	public Admin_ProductPageObject clickToProductOfCatolog() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_DashboardUI.CLICK_MENU_PRODUCT_LINK_OF_CATALOG);
		clickToElement(driver, Admin_DashboardUI.CLICK_MENU_PRODUCT_LINK_OF_CATALOG);
		return new Admin_ProductPageObject(driver);
	}
	

}
