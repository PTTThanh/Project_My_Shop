package pageObject.damin;

import org.bouncycastle.crypto.digests.GeneralDigest;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DashBoardPageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AdminLoginPageUI.CLICK_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.CLICK_LOGIN_BUTTON);
		return PageGenerator.getDashBoardPageObject(driver);
	}
	
}
