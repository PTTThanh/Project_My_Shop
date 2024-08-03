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
import pageObject.ProductNotebookPageObject;

public class Nop_05_Sort_Display_Paging extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private ProductNotebookPageObject productNotebook;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		homePage.clickToComputerHeader();
		productNotebook = homePage.clickToNotebooks();
	}

	@Test
	public void TC_01_Sort_Name_A_TO_Z() {
		productNotebook.selectItemInProductSortDropdown("Name: A to Z");
		productNotebook.sleepInSecond(2);
		Assert.assertTrue(productNotebook.isDataStringSortedAscending());

	}
	@Test
	public void TC_02_Sort_Name_Z_TO_A() {
		productNotebook.selectItemInProductSortDropdown("Name: Z to A");
		productNotebook.sleepInSecond(2);
		Assert.assertTrue(productNotebook.isDataStringSortedDescending());
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High() {
		productNotebook.selectItemInProductSortDropdown("Price: Low to High");
		productNotebook.sleepInSecond(2);
		Assert.assertTrue(productNotebook.isDataFloatSortedAscending());
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low() {
		productNotebook.selectItemInProductSortDropdown("Price: High to Low");
		productNotebook.sleepInSecond(2);
		Assert.assertTrue(productNotebook.isDataFloatSortedDescending());
	}

	@Test
	public void TC_05_Display_3_Product_On_Page() {
		productNotebook.displayProductOnPage("6");
		productNotebook.sleepInSecond(2);
	}

	@Test
	public void TC_06_Sub_Categories_Advance_Search() {

	}

	@Test
	public void TC_07_Incorrect_Manufacturer_Advance_Search() {

	}

	@Test
	public void TC_08_Correct_Manufacturer_Advance_Search() {

	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
