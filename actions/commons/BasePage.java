package commons;



	import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.user.HomePageObject;
import pageUIs.user.BasePageUI;
import pageUIs.user.RegisterPageUI;

	public class BasePage {
		//Không cần tạo đối tượng mà vẫn truy cập dc -- static
//		public static BasePage getBasePage(WebDriver driver) {
//			return new BasePage();
//		}
		
		public void getURL(WebDriver driver, String url) {
			driver.get(url);
		}

		public String getTitle(WebDriver driver) {
			return driver.getTitle();
		}

		public String getCurrentURL(WebDriver driver) {
			return driver.getCurrentUrl();
		}

		public String getPageSource(WebDriver driver) {
			return driver.getPageSource();
		}

		// navigate
		public void backToPage(WebDriver driver) {
			driver.navigate().back();
		}

		public void forwardToPage(WebDriver driver) {
			driver.navigate().forward();
		}

		public void refreshToPage(WebDriver driver) {
			driver.navigate().refresh();
		}

		// Alert
		public void waitAlertPresence(WebDriver driver) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.alertIsPresent());
		}

		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}

		public void cancelAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}

		public String getTextAlert(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}

		public void sendkeyToAlert(WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);
		}

		// WINDOWS
		public void switchToWindowByID(WebDriver driver, String parentID) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindow : allWindows) {
				if (!runWindow.equals(parentID)) {
					driver.switchTo().window(runWindow);
					break;
				}
			}
		}

		public void switchToWindowByTitle(WebDriver driver, String title) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindows : allWindows) {
				driver.switchTo().window(runWindows);
				String currentWin = driver.getTitle();
				if (currentWin.equals(title)) {
					break;
				}
			}
		}

		public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindows : allWindows) {
				if (!runWindows.equals(parentID)) {
					driver.switchTo().window(runWindows);
					driver.close();
				}
			}
			driver.switchTo().window(parentID);
		}
		public By getByLocator(String locatorValue) {
			By by = null;
			if(locatorValue.startsWith("xpath=")|| locatorValue.startsWith("XPath=")||locatorValue.startsWith("XPATH")) {
				by = By.xpath(locatorValue.substring(6));
			}else if (locatorValue.startsWith("css=")|| locatorValue.startsWith("Css=")||locatorValue.startsWith("CSS")) {
				by = By.cssSelector(locatorValue.substring(4));
			}else if (locatorValue.startsWith("id=")|| locatorValue.startsWith("Id=")||locatorValue.startsWith("ID")) {
				by = By.id(locatorValue.substring(3));
			}else if (locatorValue.startsWith("name=")|| locatorValue.startsWith("Name=")||locatorValue.startsWith("NAME")) {
				by = By.name(locatorValue.substring(5));
			}else if (locatorValue.startsWith("class=")|| locatorValue.startsWith("Class=")||locatorValue.startsWith("CLASS")) {
				by = By.className(locatorValue.substring(6));
			}else if (locatorValue.startsWith("tagname=")|| locatorValue.startsWith("Tagname=")||locatorValue.startsWith("TAGNAME")) {
				by = By.tagName(locatorValue.substring(6));
			}else {
				throw new RuntimeException("Locator type is not valid");
			}
			return by;
		}
		public String getDynamicLocator(String locator, String... values) {
			return String.format(locator, (Object[]) values);
		}

		public By getByXpath(String locator) {
			return By.xpath(locator);
		}

		public WebElement getElement(WebDriver driver, String locator) {
			return driver.findElement(getByLocator(locator));
		}

		public List<WebElement> getElements(WebDriver driver, String locator) {
			return driver.findElements(getByLocator(locator));
		}
		public List<WebElement> getElements(WebDriver driver, String locator, String...values) {
			return driver.findElements(getByLocator(getDynamicLocator(locator, values)));
		}

		public void clickToElement(WebDriver driver, String locator) {
			getElement(driver, locator).click();
		}
		public void clickToElement(WebDriver driver, String locator, String...values) {
			getElement(driver, getDynamicLocator(locator, values)).click();
		}
		public void clickToElement(WebDriver driver, WebElement element) {
			element.click();
		}
		public void sendkeyToElement(WebDriver driver, String locator, String value) {
			getElement(driver, locator).clear();
			getElement(driver, locator).sendKeys(value);
		}
		public void sendkeyToElement(WebDriver driver, String locator, String value, String...values) {
			getElement(driver, getDynamicLocator(locator, values)).clear();
			getElement(driver, getDynamicLocator(locator, values)).sendKeys(value);
		}

		public void selectByIndex(WebDriver driver, String locator, String value) {
			new Select(getElement(driver, locator)).selectByValue(value);
		}
		public void selectByValue(WebDriver driver, String locator, String value, String...values) {
			new Select(getElement(driver, getDynamicLocator(locator, values))).selectByValue(value);
		}
		public void selectVisibleText(WebDriver driver, String locator, String visibleText) {
			new Select(getElement(driver, locator)).selectByVisibleText(visibleText);
		}
//		public void selectVisibleText(WebDriver driver, String locator, String visibleText, String...values) {
//			new Select(getElement(driver, getDynamicLocator(locator, values))).selectByVisibleText(visibleText);
//		}
		public void selectVisibleText(WebDriver driver, String locator, String visibleText, String...values) {
			Select select = new Select(getElement(driver, getDynamicLocator(locator, values)));
			select.selectByVisibleText(visibleText);
		}

		public String getFirstSelectedItemDropdown(WebDriver driver, String locator) {
			select = new Select(getElement(driver, locator));
			return select.getFirstSelectedOption().getText();
		}

		public boolean isDropdownMultiple(WebDriver driver, String locator) {
			select = new Select(getElement(driver, locator));
			return select.isMultiple();
		}

		public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
				String expectedItem) {
			getElement(driver, parentLocator).click();
			sleepInSecond(1);

			wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
			List<WebElement> allItems = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

			for (WebElement item : allItems) {
				if (item.getText().trim().equals(expectedItem)) {
					jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);

					item.click();
					sleepInSecond(1);
					break;
				}
			}
		}

		public void sleepInSecond(long timeout) {
			try {
				Thread.sleep(timeout * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public String getAttributeValue(WebDriver driver, String locator, String name) {
			return getElement(driver, locator).getAttribute(name);
		}

		public String getTextElement(WebDriver driver, String locator) {
			return getElement(driver, locator).getText();
		}
		public String getTextElement(WebDriver driver, String locator, String...values) {
			return getElement(driver, getDynamicLocator(locator, values)).getText();
		}

		public int getElementSize(WebDriver driver, String locator) {
			return getElements(driver, locator).size();
		}
		public int getElementSize(WebDriver driver, String locator, String...values) {
			return getElements(driver, getDynamicLocator(locator, values)).size();
		}

		public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
			if (!getElement(driver, locator).isSelected()) {
				getElement(driver, locator).click();
			}
		}
		public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String...value) {
			if (!getElement(driver, getDynamicLocator(locator, value)).isSelected()) {
				getElement(driver, getDynamicLocator(locator, value)).click();
			}
		}

		public void unCheckTheCheckboxOrRadio(WebDriver driver, String locator) {
			if (getElement(driver, locator).isSelected()) {
				getElement(driver, locator).click();
			}
		}

		public boolean isControlDisplayed(WebDriver driver, String locator) {
			try {
				return getElement(driver, locator).isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
		public boolean isControlDisplayed(WebDriver driver, String locator, String...values) {
			try {
				return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}

		public boolean isControlSelect(WebDriver driver, String locator) {
			try {
				return getElement(driver, locator).isSelected();
			} catch (Exception e) {
				return false;
			}
		}

		public boolean isControlEnabled(WebDriver driver, String locator) {
			try {
				return getElement(driver, locator).isEnabled();
			} catch (Exception e) {
				return false;
			}
		}

		// Frame/IFrame
		public WebDriver swichToFrame(WebDriver driver, String locator) {
			return driver.switchTo().frame(getElement(driver, locator));
		}

		public WebDriver swichToDefautContent(WebDriver driver) {
			return driver.switchTo().defaultContent();
		}

		// User Actions
		// Action - perform
		public void doubleClickToElement(WebDriver driver, String locator) {
			new Actions(driver).doubleClick(getElement(driver, locator)).perform();
		}

		public void hoverMouseToElement(WebDriver driver, String locator) {
			new Actions(driver).moveToElement(getElement(driver, locator)).perform();
		}

		public void rightClick(WebDriver driver, String locator) {
			new Actions(driver).contextClick(getElement(driver, locator)).perform();
		}

		public void dragAndDrop(WebDriver driver, String locator, String target) {
			new Actions(driver).dragAndDrop(getElement(driver, locator), getElement(driver, target)).perform();
		}

		public void scrollToElement(WebDriver driver, String locator) {
			new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
		}

		public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
			new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
		}
		// UPLOAD

		// JAVASCRIP
		public Object executeForBrowser(WebDriver driver, String javaScript) {
			jsExecutor = (JavascriptExecutor) driver;
			return jsExecutor.executeScript(javaScript);
		}

		public String getInnerText(WebDriver driver) {
			jsExecutor = (JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
		}

		public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
			jsExecutor = (JavascriptExecutor) driver;
			String textActual = (String) jsExecutor
					.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
			return textActual.equals(textExpected);
		}

		public void scrollToBottomPage(WebDriver driver) {
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}

		public void navigateToUrlByJS(WebDriver driver, String url) {
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.location = '" + url + "'");
		}

		public void highlightElement(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			String originalStyle = element.getAttribute("style");
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
					"border: 2px solid red; border-style: dashed;");
			sleepInSecond(1);
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
					originalStyle);
		}

		public void clickToElementByJS(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].click();", element);
		}

//		    public void scrollToElement(WebDriver driver, String locator) {
//		        jsExecutor = (JavascriptExecutor) driver;
//		        element = getElement(driver, locator);
//		        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
//		    }

		public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		}

		public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		}

		public boolean isImageLoaded(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			boolean status = (boolean) jsExecutor.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					element);
			if (status) {
				return true;
			} else {
				return false;
			}
		}

		// WAIT
		public void waitToElementPresence(WebDriver driver, String locator) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
		}

		public void waitForElementSelect(WebDriver driver, String locator) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
		}

		public void waitForElementClickable(WebDriver driver, String locator) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
		}
		public void waitForElementClickable(WebDriver driver, String locator, String... values) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, values))));
		}
		public void waitForElementClickable(WebDriver driver, WebElement element) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.elementToBeClickable(element));
		}
		public void waitForElementVisible(WebDriver driver, String locator) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

		}
		
		public void waitForElementVisible(WebDriver driver, String locator, String...values) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, values))));

		}

		public void waitForElementInVisible(WebDriver driver, String locator) {
			new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));

		}
		public boolean isPageLoadedSuccess(WebDriver driver) {
			WebDriverWait expliciWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			jsExecutor = (JavascriptExecutor) driver;
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				
				@Override
				public Boolean apply(WebDriver input) {
					// TODO Auto-generated method stub
					return (Boolean)jsExecutor.executeScript("return (window.jQuery !=null) && (jQuery.active === 0);");
				}
			};
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				
				@Override
				public Boolean apply(WebDriver input) {
					// TODO Auto-generated method stub
					return jsExecutor.executeScript("return document.readyState").toString().equals("comple");
				}
			};
			return expliciWait.until(jQueryLoad)&& expliciWait.until(jsLoad);
		}
		public void uploadMultipeFiles (WebDriver driver, String...fileNames) {
			String filePath = GlobalContants.UPLOAD_PATH;
			String fullFileName ="";
			for(String file:fileNames) {
				fullFileName = fullFileName + filePath + file + "\n";
			}
			fullFileName = fullFileName.trim();
			getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		}
		public boolean isPageLoadedSuccess1 (WebDriver driver) {
			WebDriverWait expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			final JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				
				@Override
				public Boolean apply(WebDriver input) {
					// TODO Auto-generated method stub
					return (Boolean) jsExcutor.executeScript("return(window.jQuery !=null) && (jquery.active ===0);");
				}
			};
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				
				@Override
				public Boolean apply(WebDriver input) {
					// TODO Auto-generated method stub
					return jsExcutor.executeScript("return document.readyState").toString().equals("comple");
				}
			};
			return expliciWait.until(jQueryLoad)&& expliciWait.until(jsLoad);
		}
		public HomePageObject clickLogoNopCommerce(WebDriver driver) {
			// TODO Auto-generated method stub
			waitForElementClickable(driver, BasePageUI.LOGO_URL);
			clickToElement(driver, BasePageUI.LOGO_URL);
			return PageGenerator.getHomePageObject(driver);
		}
		private Alert alert;
		private WebDriverWait wait;
		private long longTimeOut = 30;
		private Select select;
		private JavascriptExecutor jsExecutor;
		private Actions action;
		private WebElement element;
	

}
