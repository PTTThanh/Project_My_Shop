package commons;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;
    protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
    public WebDriver getDriverInstance () {
        return this.driver;
    }
    protected WebDriver getBrowserDriver(String browser){
       if(browser.equals("firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }else if(browser.equals("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       }else{
           throw new RuntimeException("Browser name invalid: ");
       }
       driver.get(GlobalConstants.ADMIN_NOCOMMERCE_URL);
       driver.manage().window().maximize();
       driver.manage().timeouts();
        return driver;
    }
    protected WebDriver getBrowserDriver(String browser, String url){
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else{
            throw new RuntimeException("Browser name invalid: ");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts();
        return driver;
    }
    public int getNumberRandom(){
        Random random = new Random();
        return random.nextInt(999);
    }
    protected boolean verifyTrue(boolean condition){
        boolean pass = true;
        try{
            if(condition ==true){
                System.out.println("-----------PASSED-------------");
            }else{
                System.out.println("-----------FAILED-------------");
            }
            Assert.assertTrue(condition);
        }catch(Throwable e){
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyFalse(boolean object) {
        boolean pass = true;
        try {
            if (object == false) {
                System.out.println(" -------------------------- PASSED -------------------------- ");
            } else {
                System.out.println(" -------------------------- FAILED -------------------------- ");

            }
            Assert.assertFalse(object);
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
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            System.out.println(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
