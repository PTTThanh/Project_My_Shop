package com.nopcormerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Nop_02_Login extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String fName, lName, email, password, confirmPassword, wrongPassword, wrongEmail;
	@Parameters("browser")
	@BeforeClass
	public void beforClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		registerPage = homePage.clickToRegisterLink();
		fName = "Jenny";
		lName = "Kiki";
		email = "jenny"+getNumberRandom()+"@qa.team";
		password = "123456";
		confirmPassword = "123456";
		wrongPassword = "123476";
		wrongEmail="jennyqa.team";
		registerPage = homePage.clickToRegisterLink();
		registerPage.inTextboxByID(driver,"FirstName",fName);
		registerPage.inTextboxByID(driver,"LastName",lName);
		registerPage.inTextboxByID(driver,"Email",wrongEmail);
		registerPage.inTextboxByID(driver,"Password",password);
		registerPage.inTextboxByID(driver,"ConfirmPassword",confirmPassword);
		registerPage.clickToRegisterButton();
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void TC_01_Empty_Data() {
		loginPage.clickLoginButton();
		verifyEquals(loginPage.verifyErrorMessageEmptyData(), "Please enter your email");
	}
	@Test
	public void TC_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inTextboxByID(driver, "Email", "qa.team");
		loginPage.inTextboxByID(driver, "Password", password);
		loginPage.clickLoginButton();
		verifyEquals(loginPage.verifyMessageWrongEmail(), "Wrong email");
	}
	@Test
	public void TC_03_Email_Not_Register() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inTextboxByID(driver, "Email", "hoangqw@qa.team");
		loginPage.inTextboxByID(driver, "Password", password);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorNotRegisterMessageAtEmailTextbox(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found");
	}
	@Test
	public void TC_04_Not_Input_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inTextboxByID(driver, "Email", email);
		loginPage.inTextboxByID(driver, "Password", "");
		loginPage.clickLoginButton();
		verifyEquals(loginPage.getErrorBlankPassMessageAtPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}
	@Test
	public void TC_05_Wrong_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inTextboxByID(driver, "Email", email);
		loginPage.inTextboxByID(driver, "Password", wrongPassword);
		loginPage.clickLoginButton();
		verifyEquals(loginPage.getErrorWrongPassMessageAtPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}
	@Test
	public void TC_06_Valid_Email_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inTextboxByID(driver, "Email", email);
		loginPage.inTextboxByID(driver, "Password", password);
		loginPage.clickLoginButton();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
