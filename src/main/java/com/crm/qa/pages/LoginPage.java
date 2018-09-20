package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	//PageFactory
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
    WebElement LoginButton;
	
	@FindBy(linkText="SignUp")
    WebElement SignUP;
	
	@FindBy(xpath ="//img[contains(@class ,'img-responsive')]")
    WebElement CRMLogo;
	
	//Initilazing page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String ValidateLoginPageTile()
	{
		return driver.getTitle();
	}
	
	public boolean boolenValidateCRMLogo()
	{
		return CRMLogo.isDisplayed();
		
	}
	public HomePage Login(String Us ,String Pwd)
	{
		Username.sendKeys(Us);
		Password.sendKeys(Pwd);
		LoginButton.click();
		return new HomePage();
	}
	

	
			

	
			
	
	

	
	

}
