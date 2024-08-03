package myshop.com;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
	}

	@Test
	public void TC01_Empty_Data() {
		//PageGenerator.getHomePageObject(driver);
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
		homePage = registerPageObject.clickLogoNopCommerce();
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName("Hana");
		registerPageObject.inputLastName("Truong");
		registerPageObject.inputEmail("hanatruonggmail.com");
		registerPageObject.inputPassword("123456");
		registerPageObject.inputConfirmPassword("123456");
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getEmailErrorMassage(), "Please enter a valid email address.");

	}

	@Test
	public void TC03_Information_Valid() {
		homePage = registerPageObject.clickLogoNopCommerce();
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName("Hana");
		registerPageObject.inputLastName("Truong");
		registerPageObject.inputEmail(emailAddress);
		registerPageObject.inputPassword("123456");
		registerPageObject.inputConfirmPassword("123456");
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessful(), "Your registration completed");
	}

//	// CASE ERROR UI
////	@Test
////	public void TC04_Password_Small_6_Character() {
////		registerPageObject.clickLogoNopCommerce();
////		homePage = new HomePageObject();
////		homePage.clickToLinkRegister();
////		registerPageObject = new RegisterPageObject();
////		registerPageObject.inputFirstName("");
////		registerPageObject.inputLastName("");
////		registerPageObject.inputEmail("");
////		registerPageObject.inputPassword("");
////		registerPageObject.inputConfirmPassword("");
////		registerPageObject.clickRegisterButton();
////		
////	}
	@Test
	public void TC05_ConfirmPassword_Not_Match_Password() {
		homePage = registerPageObject.clickLogoNopCommerce();
		registerPageObject = homePage.clickToLinkRegister();
		registerPageObject.inputFirstName("Hana");
		registerPageObject.inputLastName("Truong");
		registerPageObject.inputEmail("hanatruong@gmail.com");
		registerPageObject.inputPassword("123456");
		registerPageObject.inputConfirmPassword("123356");
		registerPageObject.clickRegisterButton();
		Assert.assertEquals(registerPageObject.getConfirmPasswordNotMatchPassword(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
