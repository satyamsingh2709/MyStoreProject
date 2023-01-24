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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author SINGH
 *
 */
public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void serachResultTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnLogin();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		searchResultPage = homePage.searchProduct("Phone");
		Assert.assertTrue(searchResultPage.isProductAvailable());
	}
}
