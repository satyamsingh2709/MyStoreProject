package com.mystore.testscripts;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	
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
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pwd) {
		
		Log.startTestCase("LoginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on sign in");
		loginPage = indexPage.clickOnLogin();
		
		Log.info("Enter username and password");
		//homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		homePage = loginPage.Login(uname, pwd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://tutorialsninja.com/demo/index.php?route=account/account";
		Log.info("Verifying whether user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("Test Case ends");
	}

}
