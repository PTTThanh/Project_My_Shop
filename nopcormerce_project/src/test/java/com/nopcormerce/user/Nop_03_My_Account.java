package com.nopcormerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Common_Resgister_Login;
import commons.PageGeneratorManager;
import pageObject.AddressesPageObject;
import pageObject.ChangePasswordPageObject;
import pageObject.DetailProductPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;

public class Nop_03_My_Account extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	private AddressesPageObject addressPage;
	private ChangePasswordPageObject changePassPage;
	private DetailProductPageObject detailProductPage;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.userLoginPage(Common_Resgister_Login.email, Common_Resgister_Login.password);
	}

	@Test
	public void TC_01_Customer_Info() {
		homePage.clickMyAccountLink();
		myAccountPage = PageGeneratorManager.geMyAccountPageObject(driver);
		myAccountPage.inputFirstName("NaKi");
		myAccountPage.inputLastName("GiGi");
		myAccountPage.clickToSaveButton();
		verifyEquals(myAccountPage.gettTextEditSuccess(), "The customer info has been updated successfully.");

	}

	@Test
	public void TC_02_Addresses() {
		addressPage = myAccountPage.clickAdressLink();
		addressPage.clickToAddNew();
		addressPage.inputFirstNameAddress("Automation");
		addressPage.inputLastNameAddress("FC");
		addressPage.inputEmailAddress("automation@test.team");
		addressPage.selectCountry("Viet Nam");
		addressPage.inputCityAddress("Da Nang");
		addressPage.inputAddress("123/04 Le Loi");
		addressPage.inputZipPostalCodeAddress("550000");
		addressPage.inputPhoneNumberAddress("0123456789");
		addressPage.clickToSaveButton();
		verifyEquals(addressPage.getTextAddAddress(),"The new address has been added successfully.");
	}
	@Test
	public void TC_03_Change_Password() {
		changePassPage = addressPage.clickChangePassword();
		changePassPage.inputOldPassword("123456");
		changePassPage.inputNewPassword("567890");
		changePassPage.inputConfirmPassword("567890");
		changePassPage.clickToChangePasswordButton();
		changePassPage.clickToCloseIcon();
		changePassPage.sleepInSecond(2);
		changePassPage.clickToLogOut();
		loginPage = homePage.clickToLoginLink();
		loginPage.userLoginPage(Common_Resgister_Login.email, "123456");
		loginPage.sleepInSecond(2);
		verifyEquals(loginPage.getErrorWrongPassMessageAtPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
		loginPage.sleepInSecond(2);
		loginPage.userLoginPage(Common_Resgister_Login.email, "567890");
	}
	@Test
	public void TC_04_My_Product_Review () {
		homePage = PageGeneratorManager.getHomePageObject(driver);
		detailProductPage = homePage.clickToTitleProduct();
		homePage.sleepInSecond(2);
		detailProductPage.clickToAddYourReview();
		detailProductPage.inputTitleReview("I want to review");
		detailProductPage.inputTextAreaRevieText("Prodcut is good. I like productive works of productProdcut is good. I like productive works of product");
	    detailProductPage.clickToSubmitReviewButton();
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
