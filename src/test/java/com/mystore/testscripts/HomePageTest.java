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

/**
 * @author SINGH
 *
 */
public class HomePageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	public void verifyMyAccount() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnLogin();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(homePage.isMyAccountElementDisplayed());
	}
	
	@Test(groups = "Smoke")
	public void verifyMyOrder() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnLogin();
		homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(homePage.isMyOrdersElementDisplayed());		
	}
}
