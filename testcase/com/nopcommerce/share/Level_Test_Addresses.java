package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
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

public class Level_Test_Addresses extends BaseTest {
	
	private WebDriver driver;
	private HomePageObject homePageObject;

	private UserLoginPageObject loginPageObject;
	private MyAccountPageObject myAccountPageObject;

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		driver = getBrowserName(browser);
		homePageObject = PageGenerator.getHomePageObject(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(Level_20_Common_Register.email);
		loginPageObject.inputPassword(Level_20_Common_Register.password);
		loginPageObject.clickToLoginButton();
	}

	@Test
	public void TC1_Confirm_Info_Login() {
		myAccountPageObject = homePageObject.clickToLinkMyAccount();
		Assert.assertEquals(myAccountPageObject.getValueFirstName(), Level_20_Common_Register.fName);
		Assert.assertEquals(myAccountPageObject.getValueLastName(), Level_20_Common_Register.lName);
		Assert.assertEquals(myAccountPageObject.getValueEmail(), Level_20_Common_Register.email);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
