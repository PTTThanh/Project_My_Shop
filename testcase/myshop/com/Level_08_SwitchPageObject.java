//package myshop.com;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import commons.BaseTest;
//import commons.PageGenerator;
//import pageObjects.user.AddressPageObject;
//import pageObjects.user.BackInStockSubscriptionsPagetObject;
//import pageObjects.user.ChangePasswordPageObject;
//import pageObjects.user.DownloadProductPageObject;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.MyAccountPageObject;
//import pageObjects.user.MyProductReviewPageObject;
//import pageObjects.user.OrderPageObject;
//import pageObjects.user.RegisterPageObject;
//import pageObjects.user.RewardPointPageObject;
//import pageObjects.user.UserLoginPageObject;
//
//public class Level_08_SwitchPageObject extends BaseTest {
//	private String email = getEmailRandom();
//	private WebDriver driver;
//	private HomePageObject homePageObject;
//	private RegisterPageObject registerPageObject;
//	private UserLoginPageObject loginPageObject;
//	private MyAccountPageObject myAccountPageObject;
//	private AddressPageObject addressPageObject;
//	private OrderPageObject orderPageObject;
//	private DownloadProductPageObject downloadProductPageObject;
//	private BackInStockSubscriptionsPagetObject backInStockSubscriptionsPagetObject;
//	private RewardPointPageObject rewardPointPageObject;
//	private ChangePasswordPageObject changePasswordPageObject;
//	private MyProductReviewPageObject myProductReviewPageObject;
//	@BeforeClass
//	@Parameters("browser")
//	public void beforeClass(String browser) {
//		driver = getBrowserName(browser);
//	}
//	@Test
//	public void TC1_Register_Page_Success () {
//		homePageObject = PageGenerator.getHomePageObject(driver);
//		registerPageObject = homePageObject.clickToLinkRegister();
//		registerPageObject.inputFirstName("lune");
//		registerPageObject.inputLastName("susi");
//		registerPageObject.inputEmail(email);
//		registerPageObject.inputPassword("123456");
//		registerPageObject.inputConfirmPassword("123456");
//		registerPageObject.clickRegisterButton();
//		
//	}
//	@Test
//	public void TC2_Login_Page_Success() {
//		homePageObject = registerPageObject.clickToLinkLogOut();
//		loginPageObject = homePageObject.clickToLinkLogin();
//		loginPageObject.inputEmail(email);
//		loginPageObject.inputPassword("123456");
//		loginPageObject.clickToLoginButton();
//	}
//	@Test
//	public void TC3_Confirm_Info_Login() {
//		myAccountPageObject = homePageObject.clickToLinkMyAccount();
//		Assert.assertEquals(myAccountPageObject.getValueFirstName(), "lune");
//		Assert.assertEquals(myAccountPageObject.getValueLastName(), "susi");
//		Assert.assertEquals(myAccountPageObject.getValueEmail(), email);
//	}
//	@Test
//	public void TC4_Switch_Page_Object() {
//		//Customer info -> Address
//		addressPageObject = myAccountPageObject.clickToMenuAddress(driver);
//		Assert.assertEquals(addressPageObject.getTextTitle(), "My account - Addresses");
//		orderPageObject = addressPageObject.clickToLinkOrder(driver);
//		Assert.assertEquals(orderPageObject.getTextTitle(), "My account - Orders");
//		downloadProductPageObject= orderPageObject.clickToLinkDownloadProduct(driver);
//		Assert.assertEquals(downloadProductPageObject.getTextTitle(), "My account - Downloadable products");
//		backInStockSubscriptionsPagetObject = downloadProductPageObject.clickToBackInStockSubscription(driver);
//		Assert.assertEquals(backInStockSubscriptionsPagetObject.getTextTitle(), "My account - Back in stock subscriptions");
//		rewardPointPageObject = backInStockSubscriptionsPagetObject.clickToLinkRewardPoint(driver);
//		Assert.assertEquals(rewardPointPageObject.getTextTitle(), "My account - Reward points");
//		changePasswordPageObject = rewardPointPageObject.clickToLinkChangePassword(driver);
//		Assert.assertEquals(changePasswordPageObject.getTextTitle(), "My account - Change password");
//		myProductReviewPageObject = changePasswordPageObject.clickToLinkMyProductReview(driver);
//		Assert.assertEquals(myProductReviewPageObject.getTextTitle(), "My account - My product reviews");
//		
//	}
//	@AfterClass
//	public void afterClass() {
//		closeBrowser();
//	}
//
//}
