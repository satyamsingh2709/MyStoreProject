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
public class SearchResultPage extends BaseClass{

	@FindBy (xpath = "//div[@class=\"product-thumb\"]//img")
	WebElement productList;
	
	//constructor to initialise webelements of this class
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}	
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productList);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productList);
		return new AddToCartPage();
	}
}
