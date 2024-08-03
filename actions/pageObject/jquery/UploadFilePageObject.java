package pageObject.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.UploadPageUI;

public class UploadFilePageObject extends BasePage {
	WebDriver driver;

	public UploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isControlDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickStartButtonOnEachFile() {
		// TODO Auto-generated method stub
		List <WebElement> startButtons = getElements(driver, UploadPageUI.MULTIPE_START_BUTTON);
		for(WebElement buttons: startButtons) {
			waitForElementClickable(driver, buttons);
			clickToElement(driver, buttons);
		}
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isControlDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}
	
}
