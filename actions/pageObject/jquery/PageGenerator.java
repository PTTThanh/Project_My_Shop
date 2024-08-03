package pageObject.jquery;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static UploadFilePageObject getUploadFilePageObject(WebDriver driver) {
		return new UploadFilePageObject(driver);
	}
}
