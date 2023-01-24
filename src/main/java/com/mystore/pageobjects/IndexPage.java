package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy (xpath = "//a[@title=\"My Account\"]")
	WebElement myAccount;
	
	@FindBy (xpath = "//a[text()=\"Register\"]")
	WebElement register;
	
	@FindBy (xpath = "//a[text()=\"Login\"]")
	WebElement login;
	
	@FindBy (xpath = "//a[text()=\"Your Store\"]")
	WebElement logo;
	
	@FindBy (xpath = "//div[@id=\"search\"]/input")
	WebElement searchProductBox;
	
	@FindBy (xpath = "//div[@id=\"search\"]/span/button")
	WebElement searchButton;
	
	//constructor to initialise webelements of this class
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnMyAccount() {
		Action.click(getDriver(), myAccount);
	}
	
	public LoginPage clickOnLogin() {
		clickOnMyAccount();
		Action.click(getDriver(), login);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), logo);
	}
	
	public String getMyStoreTitle() {
		String pageTitle =  Action.getTitle(getDriver());
		return pageTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox,productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
}
