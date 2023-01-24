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
public class LoginPage extends BaseClass{

	@FindBy (xpath = "//input[@id=\"input-email\"]")
	WebElement email;
	
	@FindBy (xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy (xpath = "//input[@value=\"Login\"]")
	WebElement loginButton;
	
	@FindBy (xpath = "//a[text()=\"Forgotten Password\"]")
	WebElement forgotPassword;
	
	//constructor to initialise webelements of this class
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage Login(String uname, String pword) {
		Action.type(email, uname);
		Action.type(password, pword);
		Action.click(getDriver(), loginButton);
		return new HomePage();
	}
}
