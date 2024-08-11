package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Logger log;
	public BaseTest() {
		log=LogManager.getLogger(getClass());
	}
	
	@Parameters("browser")
	protected WebDriver getBrowserName(String browerName) {
		BrowserList browser = BrowserList.valueOf(browerName.toUpperCase());
		if (browser == BrowserList.CHROME) {
			driver = WebDriverManager.chromedriver().create();
		}
//		}else if(browser ==BrowserList.FIREFOX) {
//			driver = WebDriverManager.firefoxdriver().create();
//		}
		else {
			throw new RuntimeException("Browser name is not value.");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalContants.DEV_USER_URL);
		return driver;
	}

	protected WebDriver getBrowserName(String browerName, String url) {
		BrowserList browser = BrowserList.valueOf(browerName.toUpperCase());
		if (browser == BrowserList.CHROME) {
			driver = WebDriverManager.chromedriver().create();
		}
//		}else if(browser ==BrowserList.FIREFOX) {
//			driver = WebDriverManager.firefoxdriver().create();
//		}
		else {
			throw new RuntimeException("Browser name is not value.");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	protected String getEmailRandom() {
		Random rand = new Random();
		return "violet" + rand.nextInt(99999) + "@gmail.com";
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("Browser is closed");
		} else {
			driver.quit();
		}
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
