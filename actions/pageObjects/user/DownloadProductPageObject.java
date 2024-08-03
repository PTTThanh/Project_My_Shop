package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator;
import pageUIs.user.DownloadProductPageUI;

public class DownloadProductPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public DownloadProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, DownloadProductPageUI.TEXT_TITLE_DOWNLOAD_PRODUCT);
		return getTextElement(driver, DownloadProductPageUI.TEXT_TITLE_DOWNLOAD_PRODUCT);
	}

	
	
}
