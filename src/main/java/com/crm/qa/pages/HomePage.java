package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class HomePage extends Testbase {
	
	//PageFactory 
	
	@FindBy(xpath= "//td[contains(text(),'User: Varun T')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement Newcontactlink;

	


    public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	
public String verifyHomePageTitle()
{
	return driver.getTitle();
}

public boolean verifycorrectUserName()
{
	return usernameLabel.isDisplayed();
}

public ContactPage clickOnContactLink()
{
	contactslink.click();
	return new ContactPage();
	
}
public DealsPage clickOnDealsLink()
{
	dealslink.click();
	return new DealsPage();

}
public TaskPage clickOnTaskLink()
{
	tasklink.click();
	return new TaskPage();

}
public void clickonNewContactLink()
{
	Actions action = new Actions(driver);
	action.moveToElement(contactslink).build().perform();
	Newcontactlink.click();
	
}

}