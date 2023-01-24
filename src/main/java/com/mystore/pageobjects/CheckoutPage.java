package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckoutPage extends BaseClass{
	
	@FindBy (xpath = "(//table[@class=\"table table-bordered\"])[2]//tbody//td[@class=\"text-right\"]")
	WebElement unitPrice;
	
	@FindBy (xpath = "((//table[@class=\"table table-bordered\"])[2]//tbody//td[@class=\"text-right\"])[2]")
	WebElement totalPrice;
	
	@FindBy (xpath = "//a[text()=\"Checkout\"]")
	WebElement checkoutButton;
	
	@FindBy (xpath = "//div[contains(text(),'Products marked')]//i")
	WebElement confirmMessage;
	
	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String uPrice = unitPrice.getText();
		String uPrice1 = uPrice.replaceAll("[^a-zA-Z0-9]" ,"");
		double finalUnitPrice = Double.parseDouble(uPrice1);
		return finalUnitPrice/100;
	}

	public double getTotalPrice() {
		String tPrice = totalPrice.getText();
		String tPrice1 = tPrice.replaceAll("[^a-zA-Z0-9]" ,"");
		double finalTotalPrice = Double.parseDouble(tPrice1);
		return finalTotalPrice/100;
	}
	
	public void clickOnCheckout() {
		Action.click(getDriver(), checkoutButton);
	}
	
	public String validateMessage() {
		String message =confirmMessage.getText();
		return message;
	}
}
