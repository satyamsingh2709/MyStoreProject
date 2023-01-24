/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.CheckoutPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author SINGH
 *
 */
public class CheckoutPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() {
		Log.startTestCase("VerifyTotalPrice");
		indexPage = new IndexPage();
		
		loginPage = indexPage.clickOnLogin();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		searchResultPage = homePage.searchProduct("Phone");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickAddToCart();
		checkoutPage = addToCartPage.clickOnCheckOut();
		double unitPrice = checkoutPage.getUnitPrice();
		double actualTotalPrice = checkoutPage.getTotalPrice();
		double expectedTotalPrice = unitPrice*2;
		Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
		
	}
	
//	@Test
//	public void verifyMessage() {
//		indexPage = new IndexPage();
//		
//		loginPage = indexPage.clickOnLogin();
//		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
//		searchResultPage = homePage.searchProduct("Phone");
//		addToCartPage = searchResultPage.clickOnProduct();
//		addToCartPage.enterQuantity("3");
//		addToCartPage.clickAddToCart();
//		checkoutPage = addToCartPage.clickOnCheckOut();
//		String actualMessage = checkoutPage.validateMessage();
//		String expectedMessage = "Products marked";
//		Assert.assertEquals(actualMessage, expectedMessage);
//
//	}
	
}
