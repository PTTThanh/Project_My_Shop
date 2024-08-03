package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
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

public class Level_17_Report_Screen_Shot extends BaseTest {
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
	private String adminUrl = GlobalContants.DEV_ADMIN_URL;
	private String userUrl = GlobalContants.DEV_USER_URL;

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		driver = getBrowserName(browser);
	}

	@Test
	public void TC1_Register_Page_Success() {
		homePageObject = PageGenerator.getHomePageObject(driver);
		log.info("User_01 - Step 01: Click to Link Register on Homepage");
		registerPageObject = homePageObject.clickToLinkRegister();
		log.info("User_01 - Step 02: Input First Name ");
		registerPageObject.inputFirstName("lune");
		log.info("User_01 - Step 03: Input Last Name");
		registerPageObject.inputLastName("susi");
		log.info("User_01 - Step 04: Input Email");
		registerPageObject.inputEmail(email);
		log.info("User_01 - Step 05: Input Password");
		registerPageObject.inputPassword("123456");
		log.info("User_01 - Step 06: Input Confirm Password");
		registerPageObject.inputConfirmPassword("123456");
		log.info("User_01 - Step 07: Click to Register Button");
		registerPageObject.clickRegisterButton();
	}

	@Test
	public void TC2_Login_Page_Success() {
		log.info("User_01 - Step 08: Click To Link Log Out ");
		homePageObject = registerPageObject.clickToLinkLogOut();
		log.info("User_01 - Step 09: Click To Link Login on HomePage");
		userLoginPageObject = homePageObject.clickToLinkLogin();
		log.info("User_01 - Step 10: Input Email Login");
		userLoginPageObject.inputEmail(email);
		log.info("User_01 - Step 11: Input Email Password");
		userLoginPageObject.inputPassword("123456");
		log.info("User_01 - Step 12: Click to Login Button");
		userLoginPageObject.clickToLoginButton();
	}

	@Test
	public void TC3_Confirm_Info_Login() {
		log.info("User_01 - Step 13: Click To Link My Account");
		myAccountPageObject = homePageObject.clickToLinkMyAccount();
		log.info("User_01 - Step 14: Verify Value First Name ");
		Assert.assertEquals(myAccountPageObject.getValueFirstName(), "lune");
		log.info("User_01 - Step 15: Verify Value Last Name ");
		verifyEquals(myAccountPageObject.getValueLastName(), "susi");
		log.info("User_01 - Step 16: Verify Value Email ");
		verifyEquals(myAccountPageObject.getValueEmail(), email);
	}

	@Test
	public void TC4_02_Switch_Page_Object() {
		// Customer info -> Address
		myAccountPageObject.openDynamicSideBarPage("Addresses");
		addressPageObject = PageGenerator.getAddressPageObject(driver);
		verifyEquals(addressPageObject.getTextTitle(), "My account - Addresses");
		addressPageObject.openDynamicSideBarPage("Orders");
		orderPageObject = PageGenerator.getOrderPageObject(driver);
		verifyEquals(orderPageObject.getTextTitle(), "My account - Orders");
		orderPageObject.openDynamicSideBarPage("Downloadable products");
		downloadProductPageObject = PageGenerator.getDownloadProductPageObject(driver);
		verifyEquals(downloadProductPageObject.getTextTitle(), "My account - Downloadable products");
		downloadProductPageObject.openDynamicSideBarPage("Back in stock subscriptions");
		backInStockSubscriptionsPagetObject = PageGenerator.getBackInStockSubscriptionsPagetObject(driver);
		verifyEquals(backInStockSubscriptionsPagetObject.getTextTitle(), "My account - Back in stock subscriptions");
		backInStockSubscriptionsPagetObject.openDynamicSideBarPage("Reward points");
		rewardPointPageObject = PageGenerator.getRewardPointPageObject(driver);
		verifyEquals(rewardPointPageObject.getTextTitle(), "My account - Reward points");
		rewardPointPageObject.openDynamicSideBarPage("Change password");
		changePasswordPageObject = PageGenerator.getChangePasswordPageObject(driver);
		verifyEquals(changePasswordPageObject.getTextTitle(), "My account - Change password");
		changePasswordPageObject.openDynamicSideBarPage("My product reviews");
		myProductReviewPageObject = PageGenerator.getMyProductReviewPageObject(driver);
		verifyEquals(myProductReviewPageObject.getTextTitle(), "My account - My product reviews");
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
