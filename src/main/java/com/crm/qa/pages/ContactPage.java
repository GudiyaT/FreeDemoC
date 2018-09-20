package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.Testbase;

public class ContactPage extends Testbase {
	
	//PageFactory 
	
	@FindBy(xpath= "//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="middle_initial")
	WebElement MiddleName;
	
	
	@FindBy(name="client_lookup")
	WebElement company;

	
	
	//Initializing page objects
	
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyContactlabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public void createnewContact(String titles ,String firstname,String Middlename, String companys) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(titles);
		FirstName.sendKeys(firstname);
		MiddleName.sendKeys(Middlename);
		company.sendKeys(companys);
		
		
		
		
	}
	
	

}
