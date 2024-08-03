package com.jquery.table;

import org.openqa.selenium.WebDriver;

import commons.GlobalContants;
import pageUIs.user.BasePageUI;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fileNames = {"nui.png","phuquoc.png"};
		String filePath = GlobalContants.UPLOAD_PATH;
		System.out.println(filePath);
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
			System.out.println(fullFileName);
		}
//		fullFileName = fullFileName.trim();
//		getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}

}
