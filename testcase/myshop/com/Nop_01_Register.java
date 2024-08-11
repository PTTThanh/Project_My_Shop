package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Nop_01_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPageObject;
	private String emailAddress = getEmailRandom();
	private String fName, lName, password, confirmPassword, invalidEmail;

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		fName = "Hana";
		lName = "Truong";
		password = "123456";
		confirmPassword = "123456";
		invalidEmail = "hanatruonggmail.com";
	}

	@Test
	public void TC01_Empty_Data() {
		homePage = PageGenerator.getHomePageObject(driver);
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getFirstNameErrorMassage(), "First name is required.");
		Assert.assertEquals(registerPageObject.getLastNameErrorMassage(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getEmailErrorMassage(), "Email is required.");
		Assert.assertEquals(registerPageObject.getPassowrdErrorMassage(), "Password is required.");
	}

	@Test
	public void TC02_Invalid_Email() {
		homePage = registerPageObject.clickLogoNopCommerce(driver);
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName(fName);
		registerPageObject.inputLastName(lName);
		registerPageObject.inputEmail(invalidEmail);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(confirmPassword);
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getEmailErrorMassage(), "Please enter a valid email address.");

	}
	@Test
	public void TC03_ConfirmPassword_Not_Match_Password() {
		homePage = registerPageObject.clickLogoNopCommerce(driver);
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName(fName);
		registerPageObject.inputLastName(lName);
		registerPageObject.inputEmail(emailAddress);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword("123356");
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getConfirmPasswordNotMatchPassword(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void TC04_Information_Valid() {
		homePage = registerPageObject.clickLogoNopCommerce(driver);
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName(fName);
		registerPageObject.inputLastName(lName);
		registerPageObject.inputEmail(emailAddress);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(confirmPassword);
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessful(), "Your registration completed");
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
