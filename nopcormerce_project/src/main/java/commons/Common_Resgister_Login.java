package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Common_Resgister_Login extends BaseTest {
	private WebDriver driver;
	public static String email,password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName,confirmPassword;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email = "test" + getNumberRandom() + "@qa.team";
		firstName = "David";
		lastName = "Jira";
		password = "123456";
		confirmPassword = "123456";


		homePage = PageGeneratorManager.getHomePageObject(driver);
	
		registerPage.inTextboxByID(driver,"Password",password);
//		log.info("Register-Step 01: Click to Register link: ");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register-Step 02: Input to first name " + firstName);
		registerPage.inTextboxByID(driver,"FirstName",firstName);;
		log.info("Register-Step 03: Input to last name " + lastName);
		registerPage.inTextboxByID(driver,"LastName",lastName);
		log.info("Register-Step 03: Input to email " + email);
		registerPage.inTextboxByID(driver,"Email",email);
		log.info("Register-Step 04: Input to password " + password);
		log.info("Register-Step 05: Input to password " + confirmPassword);
		registerPage.inTextboxByID(driver,"ConfirmPassword",confirmPassword);
		log.info("Register-Step 06: Click to Register button: ");
		registerPage.clickToRegisterButton();
		log.info("Register-Step 07: Verify message register successfully: ");
		verifyEquals(registerPage.verifyRefisteSuccessfully(), "Your registration completed");
		log.info("Register-Step 08: Click to Continute button ");
		homePage = registerPage.clickToContinuteButton();
		driver.close();
	}

}
