package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import pageObject.damin.AdminLoginPageObject;
import pageObject.damin.DashBoardPageObject;
import pageObjects.user.AddressPageObject;
import pageObjects.user.BackInStockSubscriptionsPagetObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.DownloadProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_10_Switch_Role_User extends BaseTest {
	private String email = getEmailRandom();
	private WebDriver driver;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private UserLoginPageObject userLoginPageObject;
	private MyAccountPageObject myAccountPageObject;
	private AddressPageObject addressPageObject;
	private OrderPageObject orderPageObject;
	private DownloadProductPageObject downloadProductPageObject;
	private BackInStockSubscriptionsPagetObject backInStockSubscriptionsPagetObject;
	private RewardPointPageObject rewardPointPageObject;
	private ChangePasswordPageObject changePasswordPageObject;
	private MyProductReviewPageObject myProductReviewPageObject;
	private AdminLoginPageObject adminLoginPageObject;
	private DashBoardPageObject dashBoardPageObject;
	private String adminUrl, userUrl;
	@BeforeClass
	@Parameters({"browser","adminUrl","userUrl"})
	public void beforeClass(String browser, String adminUrl, String userUrl) {
		this.adminUrl = adminUrl;
		this.userUrl = userUrl;
		driver = getBrowserName(browser);
	}
	@Test
	public void TC1_Register_Page_Success () {
		homePageObject = PageGenerator.getHomePageObject(driver);
		registerPageObject = homePageObject.clickToLinkRegister();
		registerPageObject.inputFirstName("lune");
		registerPageObject.inputLastName("susi");
		registerPageObject.inputEmail(email);
		registerPageObject.inputPassword("123456");
		registerPageObject.inputConfirmPassword("123456");
		registerPageObject.clickRegisterButton();
		
	}
	@Test
	public void TC2_Login_Page_Success() {
		homePageObject = registerPageObject.clickToLinkLogOut();
		userLoginPageObject = homePageObject.clickToLinkLogin();
		userLoginPageObject.inputEmail(email);
		userLoginPageObject.inputPassword("123456");
		userLoginPageObject.clickToLoginButton();
		userLoginPageObject.getURL(driver, this.adminUrl);
		adminLoginPageObject = PageGenerator.getAdminLoginPageObject(driver);
		dashBoardPageObject = adminLoginPageObject.clickToLoginButton();
		//Assert.assertTrue(dashBoardPageObject.isPageLoadedSuccess(driver));
		adminLoginPageObject = dashBoardPageObject.clickToLogOutPage();
		adminLoginPageObject.getURL(driver, this.userUrl);
		
		
		
	}
	
	public void TC3_Switch_Page_Url() {
		
		
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
	
}
