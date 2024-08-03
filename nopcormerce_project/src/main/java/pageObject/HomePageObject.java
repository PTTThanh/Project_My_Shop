package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return new RegisterPageObject(driver);

	}

	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new LoginPageObject(driver);
	}

	public void clickMyAccountLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public DetailProductPageObject clickToTitleProduct() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.CLICK_BUILT_YOUR_OWN_COMPUTER);
		clickToElement(driver, HomePageUI.CLICK_BUILT_YOUR_OWN_COMPUTER);
		return new DetailProductPageObject(driver);
	}

	public SearchPageObject clickSeachLinkAtFooter() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.SEARCH_LINK_AT_FOOTER);
		clickToElement(driver, HomePageUI.SEARCH_LINK_AT_FOOTER);
		return new SearchPageObject(driver);
	}

	public void clickToComputerHeader() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.CLICK_COMPUTER_HEADER);
		clickToElement(driver, HomePageUI.CLICK_COMPUTER_HEADER);
	}

	public ProductNotebookPageObject clickToNotebooks() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.CLICK_NOTEBOOK);
		clickToElement(driver, HomePageUI.CLICK_NOTEBOOK);
		return new ProductNotebookPageObject(driver);
	}

	public ProductPageDesktopPageObject clickToDesktop() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.CLICK_DESKTOP);
		clickToElement(driver, HomePageUI.CLICK_DESKTOP);
		return new ProductPageDesktopPageObject(driver);
	}

}
