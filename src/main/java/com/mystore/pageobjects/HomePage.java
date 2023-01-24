/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author SINGH
 *
 */
public class HomePage extends BaseClass{

	@FindBy (xpath = "//div[@id=\"search\"]/input")
	WebElement searchProductBox;
	
	@FindBy (xpath = "//div[@id=\"search\"]/span/button")
	WebElement searchButton;

	@FindBy (xpath = "//h2[text()=\"My Account\"]")
	WebElement myAccountElement;
	
	@FindBy (xpath = "//h2[text()=\"My Orders\"]")
	WebElement myOrdersElement;
	
	@FindBy (xpath = "//a[text()=\"View your order history\"]")
	WebElement orderHistoryElement;
	
	//constructor to initialise webelements of this class
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}	
	
	public boolean isMyAccountElementDisplayed() {
		return Action.isDisplayed(getDriver(), myAccountElement);
	}
	
	public boolean isMyOrdersElementDisplayed() {
		return Action.isDisplayed(getDriver(), myOrdersElement);
	}
	
	public boolean isOrderHistoryElementDisplayed() {
		return Action.isDisplayed(getDriver(), orderHistoryElement);
	}

	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox,productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
	
	public String getCurrURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
}
