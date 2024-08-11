package myshop.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.share.Level_20_Common_Register;
import com.nopcommerce.share.Pre_Common_Register;

import commons.BaseTest;
import commons.PageGenerator;
import pageObjects.user.AddressPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.UserLoginPageObject;

public class Nop_03_MyAccount extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePageObject;
	private UserLoginPageObject loginPageObject;
	private MyAccountPageObject myAccountPageObject;
	private ChangePasswordPageObject changePasswordPageObject;
	private AddressPageObject addressPageObject;
	private UserLoginPageObject userLoginPageObject;
	private String email = "automationfc" + getEmailRandom() + "gmail.com";

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		homePageObject = PageGenerator.getHomePageObject(driver);
		loginPageObject = homePageObject.clickToLinkLogin();
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		loginPageObject.inputEmail(Pre_Common_Register.email);
		loginPageObject.inputPassword(Pre_Common_Register.password);
		loginPageObject.clickToLoginButton();
	}

	@Test
	public void TC01_Customer_Info() {
		myAccountPageObject = homePageObject.clickToLinkMyAccount();
		log.info("Update information gender ");
		myAccountPageObject.clickRadioGender();
		log.info("Update information FirstName ");
		myAccountPageObject.inputTextBoxByID("FirstName", "Automation");
		log.info("Update information LastName ");
		myAccountPageObject.inputTextBoxByID("LastName", "FC");
		log.info("Update information DateOfBirthDay ");
		myAccountPageObject.selectDateOfBirth("DateOfBirthDay", "4");
		log.info("Update information DateOfBirthMonth ");
		myAccountPageObject.selectDateOfBirth("DateOfBirthMonth", "4");
		log.info("Update information DateOfBirthYear ");
		myAccountPageObject.selectDateOfBirth("DateOfBirthYear", "2001");
		log.info("Update information email ");
		myAccountPageObject.inputTextBoxByID("Email", email);
		log.info("Update information Company Automation ");
		myAccountPageObject.inputTextBoxByID("Company", "Company Automation");
		log.info("Click to Save ");
		myAccountPageObject.clickButtonByText("Save");
		log.info("Comapre message notify update successfully");
		Assert.assertEquals(myAccountPageObject.msgUpdateSuccessful("The customer info has been updated successfully."),
				"The customer info has been updated successfully.");
	}

	@Test
	public void TC02_Addresses() {
		addressPageObject = myAccountPageObject.clickToMenuAddress();
		Assert.assertEquals(addressPageObject.getTextTitle(), "My account - Addresses");
		addressPageObject.clickButtonByText("Add new");
		addressPageObject.sleepInSecond(2);
		addressPageObject.inputTextBoxByID("Address_FirstName", "Automation");
		addressPageObject.inputTextBoxByID("Address_LastName", "FC");
		addressPageObject.inputTextBoxByID("Address_Email", email);
		addressPageObject.inputTextBoxByID("Address_Company", "Automation FC");
		addressPageObject.inputTextBoxByID("Address_CountryId", "United States");
		addressPageObject.inputTextBoxByID("Address_StateProvinceId", "Alaska");
		addressPageObject.inputTextBoxByID("Address_City", "TP Ho Chi Minh");
		addressPageObject.inputTextBoxByID("Address_Address1", "123 Binh Thanh");
		addressPageObject.inputTextBoxByID("Address_Address2", "246 Go Vap");
		addressPageObject.inputTextBoxByID("Address_ZipPostalCode", "550000");
		addressPageObject.inputTextBoxByID("Address_PhoneNumber", "0907834561");
		addressPageObject.inputTextBoxByID("Address_FaxNumber", "0987654321");
		addressPageObject.clickButtonByText("Save");
		Assert.assertEquals(myAccountPageObject.msgUpdateSuccessful("The new address has been added successfully."),
				"The new address has been added successfully.");
		// Verify information add successfully
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("name","Automation FC"),
				"Automation FC");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("email",email),
				email);
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("Phone number:","0907834561"),
				"0907834561");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("Fax number:","0987654321"),
				"0987654321");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("company","Automation FC"),
				"Automation FC");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("country","United States"),
				"United States");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("stateprovince","Alaska"),
				"Alaska");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("city","TP Ho Chi Minh"),
				"TP Ho Chi Minh");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("address1","123 Binh Thanh"),
				"123 Binh Thanh");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("address2","246 Go Vap"),
				"246 Go Vap");
		Assert.assertEquals(myAccountPageObject.verifyInfoAdressSuccessfully("zippostalcode","550000"),
				"550000");
	}
	public void Change_Password () {
		changePasswordPageObject = addressPageObject.clickToLinkChangePassword();
		Assert.assertEquals(changePasswordPageObject.getTextTitle(), "My account - Change password");
		//update new password
		changePasswordPageObject.inputTextBoxByID("OldPassword","123456");
		changePasswordPageObject.inputTextBoxByID("NewPassword", "098765");
		changePasswordPageObject.inputTextBoxByID("ConfirmNewPassword", "098765");
		changePasswordPageObject.clickButtonByText("Change password");
		Assert.assertEquals(changePasswordPageObject.msgChangePassSuccessful("Password was changed"),
				"Password was changed");
		changePasswordPageObject.clickToCloseIcon();
		homePageObject = changePasswordPageObject.clickToLogOut();
		userLoginPageObject = homePageObject.clickToLinkLogin();
		userLoginPageObject.inputEmail(email);
		userLoginPageObject.inputPassword("123456");
		homePageObject = userLoginPageObject.clickToLoginButton();
		userLoginPageObject.refreshToPage(driver);
		userLoginPageObject.inputEmail(email);
		userLoginPageObject.inputPassword("098765");
		homePageObject = userLoginPageObject.clickToLoginButton();
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
