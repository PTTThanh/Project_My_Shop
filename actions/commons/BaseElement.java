package commons;

import org.openqa.selenium.WebDriver;

import pageUIs.user.BaseElementUI;
import pageUIs.user.MyAccountPageUI;

public class BaseElement extends BasePage {
	
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void inputTextBoxByID(String inputID,String text) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,inputID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,text,inputID );
	}
	public void clickButtonByText(String textButton) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
	}
	public void selectValueByID(String selectID, String value) {
		waitForElementClickable(driver,BaseElementUI.DYNAMIC_SELECT_BY_ID, selectID);
		selectByValue(driver, BaseElementUI.DYNAMIC_SELECT_BY_ID, value, selectID);
	}
	public void clickLinkHeaderPage(String link) {
		waitForElementClickable(driver,BaseElementUI.DYNAMIC_LINK_HEADER, link);
		clickToElement(driver, BaseElementUI.DYNAMIC_LINK_HEADER, link);
	}
}
