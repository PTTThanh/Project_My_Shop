package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Admin_LoginPageUI;

public class Admin_LoginPageObject extends BasePage {
	WebDriver driver;

	public Admin_LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Admin_DashboardPageObject clickToLoginPage() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, Admin_LoginPageUI.CLICK_TO_LOGIN_BUTTON);
		clickToElement(driver, Admin_LoginPageUI.CLICK_TO_LOGIN_BUTTON);
		return new Admin_DashboardPageObject(driver);
	}
	
}
