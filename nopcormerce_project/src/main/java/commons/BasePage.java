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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUI.BaseUI;

public class BasePage {
	
	public static BasePage getBasePageObject() {
        return new BasePage();
    }
    public void openURL (WebDriver driver, String url){
        driver.get(url);
    }
    public String getTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshToPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public void waitAlertPresence (WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert (WebDriver driver){
        alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(WebDriver driver){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void sendKeyToAlert(WebDriver driver, String value){
        alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }
    public String getTextInAlert(WebDriver driver){
        alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void switchToWindowByID(WebDriver driver, String parentID){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindow : allWindows){
            if(!runWindow.equals(parentID)){
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    public void switchToWindowByTitle(WebDriver driver, String title){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindows : allWindows){
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if(currentWin.equals(title)){
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
    private By byXpath(String locator){
        return By.xpath(locator);
    }
    private WebElement findElement(WebDriver driver, String locator){
        return driver.findElement(byXpath(locator));
    }
    public List<WebElement> findElements(WebDriver driver, String locator){
        return driver.findElements(byXpath(locator));
    }
    public void clickToElement(WebDriver driver, String locator){
        findElement(driver,locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String value){
        findElement(driver,locator).clear();
        findElement(driver,locator).sendKeys(value);
    }
    public void selectByIndex (WebDriver driver, String locator, String value){
        select = new Select(findElement(driver, locator));
        select.selectByValue(value);
    }
    public void selectVisibleText (WebDriver driver, String locator, String visibleText){
        select = new Select(findElement(driver, locator));
        select.selectByVisibleText(visibleText);
    }
    public void selectItemDropdown(WebDriver driver, String locator, String itemValue) {
		select = new Select(findElement(driver, locator));
		select.selectByVisibleText(itemValue);
	}
    public String getFirstSelectedItemDropdown(WebDriver driver, String locator) {
        select = new Select(findElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        select = new Select(findElement(driver, locator));
        return select.isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
                                           String expectedItem) {
        findElement(driver, parentLocator).click();
        sleepInSecond(1);

        wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        List<WebElement> allItems = wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

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
    public String getElementAttribute (WebDriver driver, String locator, String attributeName){
        return findElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator) {
        return findElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String...values) {
        return findElement(driver,casToRestParameter(locator,values)).getText();
    }
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return findElement(driver, locator).isDisplayed();
    }

    public int countElementSize(WebDriver driver, String locator) {
        return findElements(driver, locator).size();
    }
    public int countElementSize(WebDriver driver, String locator, String...values) {
        return findElements(driver,casToRestParameter(locator, values)).size();
    }
    public void checkToCheckbox(WebDriver driver, String locator) {
        if (!findElement(driver, locator).isSelected()) {
            findElement(driver, locator).click();
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (findElement(driver, locator).isSelected()) {
            findElement(driver, locator).click();
        }
    }
    
    public boolean isControlDisplayed (WebDriver driver, String locator){
        try{
            return findElement(driver,locator).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
    public boolean isControlEnabled (WebDriver driver, String locator){
        return findElement(driver,locator).isEnabled();
    }
    public boolean isControlSelected(WebDriver driver, String locator){
        return findElement(driver,locator).isSelected();
    }
    public void switchToFrame(WebDriver driver, String locator){
        driver.switchTo().frame(findElement(driver,locator));
    }
    public void switchToDefaultPage(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        actions = new Actions(driver);
        actions.doubleClick(findElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        actions = new Actions(driver);
        actions.contextClick(findElement(driver,locator)).perform();
    }
    public void hoverClickToElement(WebDriver driver, String locator){
        actions = new Actions(driver);
        actions.moveToElement(findElement(driver,locator)).perform();
    }
    public void dragAndDropElement(WebDriver driver, String locator, String target){
        actions = new Actions(driver);
        actions.dragAndDrop(findElement(driver,locator),findElement(driver,target)).perform();
    }
    public void sendKeyToElement(WebDriver driver, String locator, Keys key){
        actions = new Actions(driver);
        actions.sendKeys(findElement(driver,locator),key).perform();
    }
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
        element = findElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                element);
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    public void waitToElementPresence(WebDriver driver, String locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
    }
    public void waitToElementVisible(WebDriver driver, String locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }
    public void waitToElementVisible(WebDriver driver, String locator, String... values) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(casToRestParameter(locator, values))));
    }
    public void waitToElementInvisible (WebDriver driver, String locator){
        try{
            wait = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitToElementClickable(WebDriver driver, String locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }

    public void waitToElementClickable(WebDriver driver, String locator, String...values){
        wait = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(byXpath(casToRestParameter(locator, values))));
    }
    public String casToRestParameter(String locator, String...values){
        locator = String.format(locator, (Object[]) values);
        return locator;
    }
    public void clickToElement(WebDriver driver, String locator, String...values){
        findElement(driver,casToRestParameter(locator, values)).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String value, String...values){
        findElement(driver,casToRestParameter(locator,values)).clear();
        findElement(driver,casToRestParameter(locator,values)).sendKeys(value);
    }
    public boolean isControlDisplayed(WebDriver driver, String locator, String...values){
        return findElement(driver, casToRestParameter(locator,values)).isDisplayed();
    }
    public void inTextboxByID(WebDriver driver,String textbox, String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, pageUI.BaseUI.DYNAMIC_TEXTBOX_BY_ID, textbox);
		sendKeyToElement(driver, pageUI.BaseUI.DYNAMIC_TEXTBOX_BY_ID, value, textbox);	
	}
    public void clickToButtonByID(WebDriver driver,String button) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, pageUI.BaseUI.DYNAMIC_BUTTON_BY_ID, button);
		sendKeyToElement(driver, pageUI.BaseUI.DYNAMIC_BUTTON_BY_ID,button);	
	}
    public Object getTextboxColumnName(WebDriver driver,String columName, String rowNumber) {
    	int columnIndex = countElementSize(driver, BaseUI.COLUMN_INDEX_BY_NAME,columName)+1;
    	waitToElementVisible(driver, BaseUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
    	return getElementText(driver, BaseUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
    }
    public void clickTextboxColumnName(WebDriver driver,String columName, String rowNumber) {
    	int columnIndex = countElementSize(driver, BaseUI.COLUMN_INDEX_BY_NAME,columName)+1;
    	waitToElementClickable(driver, BaseUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
    	clickToElement(driver, BaseUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
    }
    private WebDriverWait wait;
    private long longTimeout = 30;
    private Alert alert;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private Actions actions;
    private WebElement element;

}
