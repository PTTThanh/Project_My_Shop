package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.PageGenerator;

public class Level_13_Table extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePageObject;
	private List<String> allValueUI = new ArrayList<String>();
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass (String browserName, String url) {
		driver = getBrowserName(browserName,url);
	}
	@Test
	public void TC_01_Search() {
		homePageObject = PageGenerator.getHomePageObject(driver);
		homePageObject.inputColumnTextByName("Females","283821");
		homePageObject.sleepInSecond(2);
		homePageObject.inputColumnTextByName("Country","Afghanistan");
		homePageObject.sleepInSecond(2);
		homePageObject.inputColumnTextByName("Males","407124");
		homePageObject.sleepInSecond(2);
		homePageObject.inputColumnTextByName("Total","24853148");
		homePageObject.sleepInSecond(2);
	}
//	@Test
//	public void TC_02_Paging() {
//		homePageObject.refreshToPage(driver);
//		homePageObject.sleepInSecond(2);
//		homePageObject.clickToPageByNumber("4");
//		homePageObject.sleepInSecond(2);
//		Assert.assertTrue(homePageObject.isPageActiveByNumber("4"));
//	}
//	@Test
//	public void TC_03_Displayed() {}
//	@Test
//	public void TC_04_Icon_button_checkbox() {
//		homePageObject.refreshToPage(driver);
//		homePageObject.clickToRowActionByCountryName("Afghanistan");
//		homePageObject.sleepInSecond(2);
//	}
//	@Test
//	public void TC_05_Get_All_Column_Values() {
//		homePageObject.refreshToPage(driver);
//		homePageObject.getAllPageValueByColumnName("Country");
//		
//	}
	@Test
	public void TC_06_Action_By_Index() {
		homePageObject.getURL(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePageObject.sleepInSecond(2);
		//Nhập vào textbox tại cột Contact Person dòng thứ 2
		homePageObject.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","automation");
		homePageObject.enterToTextboxByColumnNameAndRowIndex("Company","1","automation fc");
		homePageObject.sleepInSecond(2);
		// Select dữ liệu tại cột Country dòng thứ 3
		homePageObject.selectDropdownByColumnNameAndRowIndex("Country","2","Malaysia");
		homePageObject.selectDropdownByColumnNameAndRowIndex("Country","1","Malaysia");
		// Click vào checkbox tại cột NPO? dòng thứ 1
		homePageObject.clickToCheckboxByColumnNameAndRowIndex("NPO?","2");
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
