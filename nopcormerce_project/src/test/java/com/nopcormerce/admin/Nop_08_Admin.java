package com.nopcormerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.Admin_CustomerPageObject;
import pageObject.Admin_DashboardPageObject;
import pageObject.Admin_LoginPageObject;
import pageObject.Admin_ProductPageObject;

public class Nop_08_Admin extends BaseTest {
	private WebDriver driver;
	private Admin_LoginPageObject loginPage;
	private Admin_DashboardPageObject dashboardPage;
	private Admin_ProductPageObject productPage;
	private Admin_CustomerPageObject customerPage;
	private String email;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		dashboardPage = loginPage.clickToLoginPage();
		dashboardPage.clickToCatalog();
		dashboardPage.sleepInSecond(2);
		productPage = dashboardPage.clickToProductOfCatolog();
		email="automation"+getNumberRandom()+"@fc.com";
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		productPage.inTextboxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		productPage.clickToSearchButton();
		productPage.sleepInSecond(2);
		System.out.println(productPage.getTextboxColumnName(driver, "Product name", "1"));
		verifyEquals(productPage.getTextboxColumnName(driver, "Product name", "1"),
				"Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productPage.getTextboxColumnName(driver, "SKU", "1"), "LE_IC_600");
		verifyEquals(productPage.getTextboxColumnName(driver, "Price", "1"), "500");
		verifyEquals(productPage.getTextboxColumnName(driver, "Stock quantity", "1"), "10000");
	}

	@Test
	public void TC_02_Search_With_Product() {
		productPage.refreshToPage(driver);
		productPage.inTextboxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		productPage.selectCategory("Computers");
		productPage.sleepInSecond(2);
		productPage.clickToSearchButton();
		verifyEquals(productPage.verifyEmptyNoData(), "No data available in table");
	}

	@Test
	public void TC_03_Search_With_Product_Parent_Category() {
		productPage.refreshToPage(driver);
		productPage.inTextboxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		productPage.selectCategory("Computers");
		productPage.clickToCheckBoxCategory();
		productPage.clickToSearchButton();
		productPage.sleepInSecond(2);
		System.out.println(productPage.getTextboxColumnName(driver, "Product name", "1"));
		verifyEquals(productPage.getTextboxColumnName(driver, "Product name", "1"),
				"Lenovo IdeaCentre 600 All-in-One PC");
	}

	@Test
	public void TC_04_Search_With_Product_Child_Category() {
		productPage.refreshToPage(driver);
		productPage.inTextboxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		productPage.selectCategory("Computers >> Desktops");
		productPage.clickToSearchButton();
		productPage.sleepInSecond(2);
		System.out.println(productPage.getTextboxColumnName(driver, "Product name", "1"));
		verifyEquals(productPage.getTextboxColumnName(driver, "Product name", "1"),
				"Lenovo IdeaCentre 600 All-in-One PC");
	}

	@Test
	public void TC_05_Search_With_Product_Manufacture() {
		productPage.refreshToPage(driver);
		productPage.inTextboxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		productPage.selectCategory("All");
		productPage.selectManufacture("Apple");
		productPage.clickToSearchButton();
		productPage.sleepInSecond(2);
		verifyEquals(productPage.verifyEmptyNoData(), "No data available in table");
	}

	@Test
	public void TC_06_Go_Directly_Product_SKU() {
		productPage.refreshToPage(driver);
		productPage.inTextboxByID(driver, "GoDirectlyToSku", "LE_IC_600");
		productPage.clickToGoDirectlyProduct();
		productPage.clickBackToList();
	}

	@Test
	public void TC_07_Add_New_Customer() {
		customerPage = productPage.clickToCutomerMenu();
		customerPage.clickToCustomer();
		customerPage.clickToAddNewCustomer();
		customerPage.inTextboxByID(driver, "Email", email);
		customerPage.inTextboxByID(driver, "Password", "123456");
		customerPage.inTextboxByID(driver, "FirstName", "Automation");
		customerPage.inTextboxByID(driver, "LastName", "FC");
		customerPage.clickGender();
		customerPage.inTextboxByID(driver, "DateOfBirth", "01/01/1999");
		customerPage.inTextboxByID(driver, "Company", "Automation FC");
		customerPage.clickDeleteRole();
		customerPage.selectCustomerRole("Guests");
		customerPage.inputAdminCommentTexteara("I want to learn Automation");
		customerPage.clickSaveButton();
	}

	@Test
	public void TC_08_Search_Customer_With_Email() {
		customerPage.inTextboxByID(driver, "SearchEmail", email);
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		customerPage.sleepInSecond(3);
		// verify Information
		System.out.println(customerPage.getTextboxColumnName(driver, "Email", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Email", "1"), "Guest");
		System.out.println(customerPage.getTextboxColumnName(driver, "Name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Name", "1"), "Automation FC");
		System.out.println(customerPage.getTextboxColumnName(driver, "Customer roles", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Customer roles", "1"), "Guests");
		System.out.println(customerPage.getTextboxColumnName(driver, "Company name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Company name", "1"), "Automation FC");
	}

	@Test
	public void TC_09_Search_Customer_With_FirstName_Lastname() {
		customerPage.refreshToPage(driver);
		customerPage.inTextboxByID(driver, "SearchFirstName", "Automation");
		customerPage.inTextboxByID(driver, "SearchLastName", "FC");
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		customerPage.sleepInSecond(3);
		// verify Information
		System.out.println(customerPage.getTextboxColumnName(driver, "Email", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Email", "1"), "Guest");
		System.out.println(customerPage.getTextboxColumnName(driver, "Name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Name", "1"), "Automation FC");
		System.out.println(customerPage.getTextboxColumnName(driver, "Customer roles", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Customer roles", "1"), "Guests");
		System.out.println(customerPage.getTextboxColumnName(driver, "Company name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Company name", "1"), "Automation FC");
	}

	@Test
	public void TC_10_Search_Customer_With_Company() {
		customerPage.refreshToPage(driver);
		customerPage.inTextboxByID(driver, "SearchCompany", "Automation FC");
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		customerPage.sleepInSecond(3);
		// verify Information
		System.out.println(customerPage.getTextboxColumnName(driver, "Email", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Email", "1"), "Guest");
		System.out.println(customerPage.getTextboxColumnName(driver, "Name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Name", "1"), "Automation FC");
		System.out.println(customerPage.getTextboxColumnName(driver, "Customer roles", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Customer roles", "1"), "Guests");
		System.out.println(customerPage.getTextboxColumnName(driver, "Company name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Company name", "1"), "Automation FC");
	}

	@Test
	public void TC_11_Search_Customer_With_Full_Data() {
		customerPage.refreshToPage(driver);
		customerPage.inTextboxByID(driver, "SearchEmail", email);
		customerPage.inTextboxByID(driver, "SearchFirstName", "Automation");
		customerPage.inTextboxByID(driver, "SearchLastName", "FC");
		customerPage.selectMonth("1");
		customerPage.selectDay("1");
		customerPage.inTextboxByID(driver, "SearchCompany", "Automation FC");
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		customerPage.sleepInSecond(3);
		// verify Information
		System.out.println(customerPage.getTextboxColumnName(driver, "Email", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Email", "1"), "Guest");
		System.out.println(customerPage.getTextboxColumnName(driver, "Name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Name", "1"), "Automation FC");
		System.out.println(customerPage.getTextboxColumnName(driver, "Customer roles", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Customer roles", "1"), "Guests");
		System.out.println(customerPage.getTextboxColumnName(driver, "Company name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Company name", "1"), "Automation FC");
	}
	@Test
	public void TC_12_Search_Customer_With_Full_Data() {
		customerPage.refreshToPage(driver);
		customerPage.inTextboxByID(driver, "SearchEmail", email);
		customerPage.inTextboxByID(driver, "SearchFirstName", "Automation");
		customerPage.inTextboxByID(driver, "SearchLastName", "FC");
		customerPage.selectMonth("1");
		customerPage.selectDay("1");
		customerPage.inTextboxByID(driver, "SearchCompany", "Automation FC");
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		customerPage.clickTextboxColumnName(driver, "Edit", "1");
		customerPage.inTextboxByID(driver, "Email", "edit_automation18@fc.com");
		customerPage.inTextboxByID(driver, "FirstName", "edit_Automation");
		customerPage.inTextboxByID(driver, "LastName", "edit_FC");
		customerPage.inTextboxByID(driver, "DateOfBirth", "02/02/1999");
		customerPage.inTextboxByID(driver, "Company", "Edit_Automation FC");
		customerPage.clickSaveButton();
		customerPage.inTextboxByID(driver, "SearchEmail", "edit_automation18@fc.com");
		customerPage.inTextboxByID(driver, "SearchFirstName", "edit_Automation");
		customerPage.inTextboxByID(driver, "SearchLastName", "edit_FC");
		customerPage.selectMonth("2");
		customerPage.selectDay("2");
		customerPage.inTextboxByID(driver, "SearchCompany", "Edit_Automation FC");
		customerPage.clickDeleteRole();
		customerPage.sleepInSecond(5);
		customerPage.selectCustomerRoleSearch("Guests");
		customerPage.clickToSearchButton();
		System.out.println(customerPage.getTextboxColumnName(driver, "Email", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Email", "1"), "Guest");
		System.out.println(customerPage.getTextboxColumnName(driver, "Name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Name", "1"), "Edit_Automation FC");
		System.out.println(customerPage.getTextboxColumnName(driver, "Customer roles", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Customer roles", "1"), "Guests");
		System.out.println(customerPage.getTextboxColumnName(driver, "Company name", "1"));
		verifyEquals(customerPage.getTextboxColumnName(driver, "Company name", "1"), "Edit_Automation FC");
	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
