package pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.ProductNotebookUI;

public class ProductNotebookPageObject extends BasePage {
	WebDriver driver;

	public ProductNotebookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String value) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ProductNotebookUI.SORT_BY);
		selectItemDropdown(driver, ProductNotebookUI.SORT_BY, value);
	}

	public boolean isDataStringSortedAscending() {
		// Khai báo 1 Array List
		ArrayList<String> productUIList = new ArrayList<>();
		// Tìm tất cả element matching vs điều kiện
		List<WebElement> productNameText = findElements(driver, ProductNotebookUI.NAME_PRODUCT);
		// Lấy text của từng element add vào Array List
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		System.out.println("------------------------Dữ liệu trên UI-------------------");
		for (String name : productUIList) {
			System.out.println(name);
		}
		// Copy qua 1 array list mới để sort trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : productUIList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("-------------------Dữ liệu đã SORT ASC trong code:-------------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả
		// trả về sai
		return sortedList.equals(productUIList);
	}

	public boolean isDataStringSortedDescending() {
		// Khai báo 1 Array List
		ArrayList<String> productUIList = new ArrayList<>();
		// Tìm tất cả element matching vs điều kiện
		List<WebElement> productNameText = findElements(driver, ProductNotebookUI.NAME_PRODUCT);
		// Lấy text của từng element add vào Array List
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		System.out.println("------------------------Dữ liệu trên UI-------------------");
		for (String name : productUIList) {
			System.out.println(name);
		}
		// Copy qua 1 array list mới để sort trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : productUIList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("-------------------Dữ liệu đã SORT ASC trong code:-------------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		// Reverse data để sort DESC dùng 1 trong 2 cách bên dưới
		Collections.reverse(sortedList);
		System.out.println("------------------Dữ liệu SORT DESC trong code--------------------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả
		// trả về sai
		return sortedList.equals(productUIList);
	}

	public boolean isDataFloatSortedAscending() {
		// TODO Auto-generated method stub
		// Khai báo 1 Array List
		ArrayList<Float> productUIList = new ArrayList<Float>();
		// Tìm tất cả element matching vs điều kiện
		List<WebElement> productNameText = findElements(driver, ProductNotebookUI.PRICE_PRODUCT);
		// Lấy text của từng element add vào Array List
		for (WebElement productName : productNameText) {
			productUIList.add(Float.parseFloat(productName.getText().replaceAll("[^\\d.]", "")));
			// productUIList.add(Float.parseFloat(productName.getText().replace("$",
			// "").trim()));
		}
		System.out.println("------------------------Dữ liệu trên UI-------------------");
		for (Float name : productUIList) {
			//System.out.println(name);
		}
		// Copy qua 1 array list mới để sort trong code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : productUIList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("-------------------Dữ liệu đã SORT ASC trong code:-------------");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả
		// trả về sai
		return sortedList.equals(productUIList);
	}

	public boolean isDataFloatSortedDescending() {
		// Khai báo 1 Array List
		ArrayList<Float> productUIList = new ArrayList<Float>();
		// Tìm tất cả element matching vs điều kiện
		List<WebElement> productNameText = findElements(driver, ProductNotebookUI.PRICE_PRODUCT);
		// Lấy text của từng element add vào Array List
		for (WebElement productName : productNameText) {
			productUIList.add(Float.parseFloat(productName.getText().replaceAll("[^\\d.]", "")));
		}
		System.out.println("------------------------Dữ liệu trên UI-------------------");
		for (Float name : productUIList) {
			System.out.println(name);
		}
		// Copy qua 1 array list mới để sort trong code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : productUIList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("-------------------Dữ liệu đã SORT ASC trong code:-------------");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		// Reverse data để sort DESC dùng 1 trong 2 cách bên dưới
		Collections.reverse(sortedList);
		System.out.println("------------------Dữ liệu SORT DESC trong code--------------------");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả
		// trả về sai
		return sortedList.equals(productUIList);
	}

	public void displayProductOnPage(String value) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, ProductNotebookUI.DISPLAY_PER_PAGE);
		selectItemDropdown(driver, ProductNotebookUI.DISPLAY_PER_PAGE, value);
		 //int itemCount = findElements(driver,ProductNotebookUI.COUNT_NUMBER_PER_PAGE).size();
		int itemCount = countElementSize(driver, ProductNotebookUI.COUNT_NUMBER_PER_PAGE);
		System.out.println(itemCount);
	        if (itemCount == 6) {
	            System.out.println("6 items are displayed on the page.");
	        } else {
	            System.out.println("Number of items displayed on the page is not as expected.");
	        }
	}

}
