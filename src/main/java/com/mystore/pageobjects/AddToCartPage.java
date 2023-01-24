package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	@FindBy (xpath = "//*[@id=\"input-quantity\"]")
	WebElement quantity;
	
	@FindBy (xpath = "//button[text()=\"Add to Cart\"]")
	WebElement addToCartButton;
	
	@FindBy (xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement addToCartMessage;
	
	@FindBy (xpath = "//a[@title=\"Checkout\"]")
	WebElement checkout;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}	
	
	public void enterQuantity (String Qnt) {
		Action.type(quantity, Qnt);
	}
	
	public void clickAddToCart() {
		Action.click(getDriver(), addToCartButton);
	}
	
	public boolean validateAddToCart() {
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public CheckoutPage clickOnCheckOut() {
		Action.click(getDriver(), checkout);
		return new CheckoutPage();
	}
}
