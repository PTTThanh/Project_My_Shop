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
import pageObject.RegisterPageObject;

public class Nop_01_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
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
	}

	@Test
	public void TC_01_Empty_Data() {
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.verifyErrorMessageFirstName(), "First name is required.");
		verifyEquals(registerPage.verifyErrorMessageLastName(), "Last name is required.");
		verifyEquals(registerPage.verifyErrorMessageEmail(), "Email is required.");
		verifyEquals(registerPage.verifyErrorMessagePassword(), "Password is required.");
		verifyEquals(registerPage.verifyErrorMessageConfirmPassword(), "Password is required.");
	}
	@Test
	public void TC_02_Invalid_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInSecond(3);
		registerPage.inTextboxByID(driver,"FirstName",fName);
		registerPage.inTextboxByID(driver,"LastName",lName);
		registerPage.inTextboxByID(driver,"Email",wrongEmail);
		registerPage.inTextboxByID(driver,"Password",password);
		registerPage.inTextboxByID(driver,"ConfirmPassword",confirmPassword);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.verifyErrorMessageWrongEmail(), "Wrong email");
		
	}
	@Test
	public void TC_03_Valid_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inTextboxByID(driver,"FirstName",fName);
		registerPage.inTextboxByID(driver,"LastName",lName);
		registerPage.inTextboxByID(driver,"Email",email);
		registerPage.inTextboxByID(driver,"Password",password);
		registerPage.inTextboxByID(driver,"ConfirmPassword",confirmPassword);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.verifyRefisteSuccessfully(), "Your registration completed");
	}
	@Test
	public void TC_04_Password_Small_6_Character() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inTextboxByID(driver,"FirstName",fName);
		registerPage.inTextboxByID(driver,"LastName",lName);
		registerPage.inTextboxByID(driver,"Email",email);
		registerPage.inTextboxByID(driver,"Password","123");
		registerPage.inTextboxByID(driver,"ConfirmPassword",confirmPassword);
		registerPage.clickToRegisterButton();
		//verifyEquals(registerPage.verifyPasswordSmallCharacter(), "Your registration completed");
	}
	@Test
	public void TC_05_Confirm_Password_Not_Match_Password() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inTextboxByID(driver,"FirstName",fName);
		registerPage.inTextboxByID(driver,"LastName",lName);
		registerPage.inTextboxByID(driver,"Email",email);
		registerPage.inTextboxByID(driver,"Password",password);
		registerPage.inTextboxByID(driver,"ConfirmPassword",wrongPassword);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.verifyConfirmPasswordNotMatchPassword(), "The password and confirmation password do not match.");
		
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
