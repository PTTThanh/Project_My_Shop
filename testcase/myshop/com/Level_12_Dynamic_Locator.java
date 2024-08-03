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

public class Level_12_Dynamic_Locator extends BaseTest {
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
	private String userUrl=GlobalContants.DEV_USER_URL;
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
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
		userLoginPageObject.getURL(driver, adminUrl);
		adminLoginPageObject = PageGenerator.getAdminLoginPageObject(driver);
		dashBoardPageObject = adminLoginPageObject.clickToLoginButton();
		//Assert.assertTrue(dashBoardPageObject.isPageLoadedSuccess(driver));
		adminLoginPageObject = dashBoardPageObject.clickToLogOutPage();
		adminLoginPageObject.getURL(driver, userUrl);
		
		
		
	}
	
	@Test
	public void TC3_Confirm_Info_Login() {
		myAccountPageObject = homePageObject.clickToLinkMyAccount();
		Assert.assertEquals(myAccountPageObject.getValueFirstName(), "lune");
		Assert.assertEquals(myAccountPageObject.getValueLastName(), "susi");
		Assert.assertEquals(myAccountPageObject.getValueEmail(), email);
	}
//	@Test
//	public void TC4_01_Switch_Page_Object() {
//		//Customer info -> Address
//		addressPageObject = (AddressPageObject) myAccountPageObject.openDynamicSideBarPage("Addresses");
//		Assert.assertEquals(addressPageObject.getTextTitle(), "My account - Addresses");
//		orderPageObject = (OrderPageObject) addressPageObject.openDynamicSideBarPage("Orders");
//		Assert.assertEquals(orderPageObject.getTextTitle(), "My account - Orders");
//		downloadProductPageObject= (DownloadProductPageObject) orderPageObject.openDynamicSideBarPage("Downloadable products");
//		Assert.assertEquals(downloadProductPageObject.getTextTitle(), "My account - Downloadable products");
//		backInStockSubscriptionsPagetObject = (BackInStockSubscriptionsPagetObject) downloadProductPageObject.openDynamicSideBarPage("Back in stock subscriptions");
//		Assert.assertEquals(backInStockSubscriptionsPagetObject.getTextTitle(), "My account - Back in stock subscriptions");
//		rewardPointPageObject = (RewardPointPageObject) backInStockSubscriptionsPagetObject.openDynamicSideBarPage("Reward points");
//		Assert.assertEquals(rewardPointPageObject.getTextTitle(), "My account - Reward points");
//		changePasswordPageObject = (ChangePasswordPageObject) rewardPointPageObject.openDynamicSideBarPage("Change password");
//		Assert.assertEquals(changePasswordPageObject.getTextTitle(), "My account - Change password");
//		myProductReviewPageObject = (MyProductReviewPageObject) changePasswordPageObject.openDynamicSideBarPage("My product reviews");
//		Assert.assertEquals(myProductReviewPageObject.getTextTitle(), "My account - My product reviews");
//		
//	}
	@Test
	public void TC4_02_Switch_Page_Object() {
		//Customer info -> Address
		myAccountPageObject.openDynamicSideBarPage("Addresses");
		addressPageObject = PageGenerator.getAddressPageObject(driver);
		verifyEquals(addressPageObject.getTextTitle(), "My account - Addresses");
		//Assert.assertEquals(addressPageObject.getTextTitle(), "My account - Addresses");
		addressPageObject.openDynamicSideBarPage("Orders");
		orderPageObject = PageGenerator.getOrderPageObject(driver);
		Assert.assertEquals(orderPageObject.getTextTitle(), "My account - Orders");
		orderPageObject.openDynamicSideBarPage("Downloadable products");
		downloadProductPageObject = PageGenerator.getDownloadProductPageObject(driver);
		Assert.assertEquals(downloadProductPageObject.getTextTitle(), "My account - Downloadable products");
		downloadProductPageObject.openDynamicSideBarPage("Back in stock subscriptions");
		backInStockSubscriptionsPagetObject = PageGenerator.getBackInStockSubscriptionsPagetObject(driver);
		Assert.assertEquals(backInStockSubscriptionsPagetObject.getTextTitle(), "My account - Back in stock subscriptions");
		backInStockSubscriptionsPagetObject.openDynamicSideBarPage("Reward points");
		rewardPointPageObject = PageGenerator.getRewardPointPageObject(driver);
		Assert.assertEquals(rewardPointPageObject.getTextTitle(), "My account - Reward points");
		rewardPointPageObject.openDynamicSideBarPage("Change password");
		changePasswordPageObject = PageGenerator.getChangePasswordPageObject(driver);
		Assert.assertEquals(changePasswordPageObject.getTextTitle(), "My account - Change password");
		changePasswordPageObject.openDynamicSideBarPage("My product reviews");
		myProductReviewPageObject = PageGenerator.getMyProductReviewPageObject(driver);
		Assert.assertEquals(myProductReviewPageObject.getTextTitle(), "My account - My product reviews");
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
