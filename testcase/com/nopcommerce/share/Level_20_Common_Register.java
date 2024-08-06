package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_20_Common_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	public static String fName, lName, email,password, confirmPass;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) {
		driver = getBrowserName(browser);
		homePageObject = PageGenerator.getHomePageObject(driver);
		registerPageObject = homePageObject.clickToLinkRegister();
		fName="lune";
		lName = "susi";
		email = getEmailRandom();
		password = "123456";
		confirmPass = "123456";
		registerPageObject.inputFirstName(fName);
		registerPageObject.inputLastName(lName);
		registerPageObject.inputEmail(email);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(confirmPass);
		registerPageObject.clickRegisterButton();
		//Assert.assertEquals(registerPageObject.getRegisterSuccessful(), "Your registration completed");
		
		closeBrowser();
	}

}
