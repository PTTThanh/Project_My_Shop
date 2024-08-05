package commons;

import org.openqa.selenium.WebDriver;

import pageUIs.user.BaseElementUI;

public class BaseElement extends BasePage {
	
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void inputTextBoxByID(String inputID,String fName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,inputID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,fName,inputID );
	}
	public void clickButtonByText(String textButton) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
	}
}
