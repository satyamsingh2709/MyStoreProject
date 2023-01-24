package com.mystore.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		//Get Driver from ThreadLocalMap
		return driver.get();
	}
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
//	public void loadConfig() {
//
//	}
	
	
	public void launchApp(String browserName) {
		
	
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			
			//Set Browser to threadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			
			//Set Browser to threadLocalMap
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			//Set Browser to threadLocalMap
			driver.set(new InternetExplorerDriver());
			
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 10);
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
