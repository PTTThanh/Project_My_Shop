package com.nopcormerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Common_Resgister_Login;
import commons.PageGeneratorManager;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.SearchPageObject;

public class Nop_04_Search extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private SearchPageObject seachPage;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.userLoginPage(Common_Resgister_Login.email, Common_Resgister_Login.password);
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextSearchEmptyData(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Data_Not_Exsited() {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Mackbook Pro 2050");
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextSearchNotExistData(),"No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_Product_Name_Relative () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Lenovo");
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextProduct01(), "Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(seachPage.getTextProduct02(), "Lenovo Thinkpad X1 Carbon Laptop");
	}

	@Test
	public void TC_04_Search_Product_Name_Absolute () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("ThinkPad X1 Carbon");
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextProduct02(), "Lenovo Thinkpad X1 Carbon Laptop");
	}
	@Test
	public void TC_05_Parent_Categories_Advance_Search () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Apple Macbook Pro");
		seachPage.checkBoxAdvancedSearch();
		seachPage.sleepInSecond(2);
		seachPage.chooseCategory("1");
		seachPage.sleepInSecond(3);
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextSearchNotExistData(),"No products were found that matched your criteria.");
	}
	@Test
	public void TC_06_Sub_Categories_Advance_Search () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Apple Macbook Pro");
		seachPage.checkBoxAdvancedSearch();
		seachPage.sleepInSecond(2);
		seachPage.chooseCategory("1");
		seachPage.checkSearchSubCategories();
		seachPage.clickSeachButton();
		verifyEquals(seachPage.getTextProduct3(),"Apple MacBook Pro 13-inch");
	}
	@Test
	public void TC_07_Incorrect_Manufacturer_Advance_Search () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Apple Macbook Pro");
		seachPage.checkBoxAdvancedSearch();
		seachPage.sleepInSecond(2);
		seachPage.chooseCategory("1");
		seachPage.checkSearchSubCategories();
		seachPage.chooseManufactures("2");
		seachPage.clickSeachButton();
		//verifyEquals(seachPage.getTextProduct3(),"Apple MacBook Pro 13-inch");
		verifyEquals(seachPage.getTextSearchNotExistData(),"No products were found that matched your criteria.");
	}
	@Test
	public void TC_08_Correct_Manufacturer_Advance_Search () {
		seachPage = homePage.clickSeachLinkAtFooter();
		seachPage.inputSearchName("Apple Macbook Pro");
		seachPage.checkBoxAdvancedSearch();
		seachPage.sleepInSecond(2);
		seachPage.chooseCategory("1");
		seachPage.checkSearchSubCategories();
		seachPage.chooseManufactures("1");
		seachPage.checkSearchInProductDescroption();
		seachPage.clickSeachButton();
		//verifyEquals(seachPage.getTextProduct3(),"Apple MacBook Pro 13-inch");
		verifyEquals(seachPage.getTextProduct3(),"Apple MacBook Pro 13-inch");
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
