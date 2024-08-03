package pageObject.damin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.admin.DashBoardPageUI;

public class DashBoardPageObject extends BasePage {
	WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public AdminLoginPageObject clickToLogOutPage() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,DashBoardPageUI.CLICK_LOG_OUT);
		clickToElement(driver, DashBoardPageUI.CLICK_LOG_OUT);
		return PageGenerator.getAdminLoginPageObject(driver);
	}
	

}
