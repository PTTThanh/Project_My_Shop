package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.user.UserLoginPageObject;

public class Nop_02_Login {
	private WebDriver driver;
	private UserLoginPageObject loginPageObject;

	@Test
	public void TC01_Empty_Data() {
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailErrorMgs(), "Please enter your email");

	}

	@Test
	public void TC02_Invalid_Email() {
		loginPageObject.inputEmail("");
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailErrorMgs(), "Wrong email");
	}

	@Test
	public void TC03_Email_Not_Register() {
		loginPageObject.inputEmail("");
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC04_Email_Register_Password_Not_Input() {
		loginPageObject.inputEmail("");
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}

	@Test
	public void TC05_Email_Register_Password_Input_Wrong() {
		loginPageObject.inputEmail("");
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getEmailNotRegisterErrorMgs(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}

	@Test
	public void TC06_Email_Register_Password_Input_Right() {
		loginPageObject.inputEmail("");
		loginPageObject.inputPassword("");
		loginPageObject.clickToLoginButton();
	}
}
