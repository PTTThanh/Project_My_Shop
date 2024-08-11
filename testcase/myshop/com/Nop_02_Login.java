package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.share.Pre_Common_Register;

import commons.BaseTest;
import commons.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Nop_02_Login extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePageObject;
	private UserLoginPageObject loginPageObject;
	private String invalueEmail, notRegisterEmail,wrongPass;
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		homePageObject = PageGenerator.getHomePageObject(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		invalueEmail ="thanhnguyengmail.com";
		notRegisterEmail ="nguyenkkim@gmail.com";
		wrongPass ="123476";
	}


	@Test
	public void TC01_Empty_Data() {
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailErrorMgs(), "Please enter your email");

	}

	@Test
	public void TC02_Invalid_Email() {
		homePageObject = loginPageObject.clickLogoNopCommerce(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(invalueEmail);
		loginPageObject.inputPassword(Pre_Common_Register.password);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailErrorMgs(), "Please enter a valid email address.");
	}

	@Test
	public void TC03_Email_Not_Register() {
		homePageObject = loginPageObject.clickLogoNopCommerce(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(notRegisterEmail);
		loginPageObject.inputPassword(Pre_Common_Register.password);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC04_Email_Register_Password_Not_Input() {
		homePageObject = loginPageObject.clickLogoNopCommerce(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(Pre_Common_Register.email);
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}

	@Test
	public void TC05_Email_Register_Password_Input_Wrong() {
		homePageObject = loginPageObject.clickLogoNopCommerce(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(Pre_Common_Register.email);
		loginPageObject.inputPassword(wrongPass);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}

	@Test
	public void TC06_Email_Register_Password_Input_Right() {
		homePageObject = loginPageObject.clickLogoNopCommerce(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject.inputEmail(Pre_Common_Register.email);
		loginPageObject.inputPassword(Pre_Common_Register.password);
		loginPageObject.clickToLoginButton();
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
