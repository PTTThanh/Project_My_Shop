package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ProductPageDesktopPageUI;

public class ProductPageDesktopPageObject extends BasePage {
	WebDriver driver;

	public ProductPageDesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DetailProductPageObject clickToBuildOwnComputerProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ProductPageDesktopPageUI.TEXT_BUILD_OWN_COMPUTER);
		clickToElement(driver, ProductPageDesktopPageUI.TEXT_BUILD_OWN_COMPUTER);
		return new DetailProductPageObject(driver);
	}
	public DetailProductPageObject clickToLenovoPC() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ProductPageDesktopPageUI.TEXT_LENOVO_PC);
		clickToElement(driver, ProductPageDesktopPageUI.TEXT_LENOVO_PC);
		return new DetailProductPageObject(driver);
	}
	
}
