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
import pageObject.jquery.UploadFilePageObject;

public class Level_14_UploadFile extends BaseTest {
	private WebDriver driver;
	private UploadFilePageObject uploadFilePageObject;
	String trasua ="ts.jpg";
//	String phuquoc ="phuquoc.png";
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass (String browserName, String url) {
		driver = getBrowserName(browserName,url);
	}
	@Test
	public void TC_01_Upload_Single_File() {
		uploadFilePageObject.sleepInSecond(2);
		uploadFilePageObject.uploadMultipeFiles(driver, trasua);
		uploadFilePageObject.sleepInSecond(2);
//		uploadFilePageObject.uploadMultipeFiles(driver, phuquoc);
//		uploadFilePageObject.sleepInSecond(2);
//		Assert.assertTrue(uploadFilePageObject.isFileLoadedSuccess(nui));
//		Assert.assertTrue(uploadFilePageObject.isFileLoadedSuccess(phuquoc));
//		uploadFilePageObject.clickStartButtonOnEachFile();
//		Assert.assertTrue(uploadFilePageObject.isFileUploadedSuccess(nui));
//		Assert.assertTrue(uploadFilePageObject.isFileUploadedSuccess(phuquoc));
		
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
