package com.nopcormerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Common_Resgister_Login;
import commons.PageGeneratorManager;
import pageObject.DetailProductPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.ProductPageDesktopPageObject;
import pageObject.ShoppingCartPageObject;

public class Nop_07_Order extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private ProductPageDesktopPageObject productDesktopPage;
	private DetailProductPageObject detailProductPage;
	private ShoppingCartPageObject shoppingPage;

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.userLoginPage(Common_Resgister_Login.email, Common_Resgister_Login.password);
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		homePage.clickToComputerHeader();
		productDesktopPage = homePage.clickToDesktop();
		detailProductPage = productDesktopPage.clickToBuildOwnComputerProduct();
		detailProductPage.sleepInSecond(3);
		detailProductPage.chooseProcessorDropdownList("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		detailProductPage.chooseRamDropdownList("8GB [+$60.00]");
		detailProductPage.selectHDDRadioButton();
		detailProductPage.selectOSRadioButton();
		detailProductPage.selectSorfwareCheckbox();
		detailProductPage.clickAddtoCart();
		verifyEquals(detailProductPage.verifyAddProductSuccessfully(),
				"The product has been added to your shopping cart");
		detailProductPage.clickToIconClose();
		detailProductPage.hoverClickShopping();
		detailProductPage.sleepInSecond(2);
		verifyEquals(detailProductPage.verifyCountItem(), "1 item(s)");

	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		shoppingPage = detailProductPage.clickToCartLink();
		detailProductPage =  shoppingPage.clickToEditLink();
		detailProductPage.chooseProcessorDropdownList("2.2 GHz Intel Pentium Dual-Core E2200");
		detailProductPage.chooseRamDropdownList("4GB [+$20.00]");
		detailProductPage.selectHDDRadioButton320GB();
		detailProductPage.selectOSRadioButtonHome();
		detailProductPage.uncheckSorfware();
		detailProductPage.inputNumberItem("2");
		//verifyEquals(detailProductPage.verifyPriceBeforeUpdate(),"$1,320.00");
		detailProductPage.clickToUpdateButton();
		detailProductPage.sleepInSecond(2);
		verifyEquals(detailProductPage.verifyAddProductSuccessfully(),
				"The product has been added to your shopping cart");
		detailProductPage.clickToIconClose();
		detailProductPage.hoverClickShopping();
		verifyEquals(detailProductPage.verifyPriceAfterUpdate(),"$2,640.00");
		detailProductPage.sleepInSecond(2);
	}

	@Test
	public void TC_03_Remove_From_Cart() {
		shoppingPage = detailProductPage.clickToCartLink();
		shoppingPage.clickRemoveIcon();
		//shoppingPage.clickToUpdateShoppingCart();
		verifyEquals(shoppingPage.verifyMessageEmptyShoppingCart(), "Your Shopping Cart is empty!");
	}

	@Test
	public void TC_04_Uppdate_Shopping_Cart() {
		shoppingPage.inputKeyWordSearch("Lenovo IdeaCentre 600 All-in-One PC");
		detailProductPage = shoppingPage.clickSeachButton();
		detailProductPage.clickToLenovo();
		detailProductPage.clickAddtoCart();
		verifyEquals(detailProductPage.verifyAddProductSuccessfully(),
				"The product has been added to your shopping cart");
		detailProductPage.clickToIconClose();
		shoppingPage = detailProductPage.clickToCartLink();
		shoppingPage.inputQuanlity("5");
		shoppingPage.clickToUpdateShoppingCart();
		//verifyEquals(shoppingPage.verifyTotalAfterUpdate(),"$2,500.00");
	}

	@Test
	public void TC_05_Parent_Categories_Advance_Search() {

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
