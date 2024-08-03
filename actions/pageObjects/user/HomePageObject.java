package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public RegisterPageObject clickToLinkRegister() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,HomePageUI.LINK_REGISTER);
		clickToElement(driver, HomePageUI.LINK_REGISTER);
		return PageGenerator.getRegisterPageObject(driver);
		
	}


	public UserLoginPageObject clickToLinkLogin() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.LINK_LOGIN_PAGE);
		clickToElement(driver, HomePageUI.LINK_LOGIN_PAGE);
		return PageGenerator.getLoginPageObject(driver);
	}


	public MyAccountPageObject clickToLinkMyAccount() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.LINK_MY_ACCCOUNT);
		clickToElement(driver, HomePageUI.LINK_MY_ACCCOUNT);
		return PageGenerator.getMyAccountPageObject(driver);
	}

}
