package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Testbase{
	LoginPage login;
	HomePage home;
	TestUtil testutil;
	ContactPage contactpage;
	public HomePageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil=new TestUtil();
		login =new LoginPage();
		contactpage =new ContactPage();
		home=login.Login(prop.getProperty("username"),prop.getProperty("passsword"));

	}
	
	

	@Test(priority=1)
	
	public void verifyUsernameest()
	
	{
      testutil.switchToFrame();
     Assert.assertTrue(home.verifycorrectUserName());
	}
	
	@Test(priority=2)
	
	public void ContactLinktest()
	{
	      testutil.switchToFrame();
		contactpage= home.clickOnContactLink();
		
		
	} 

		@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


	
	
}
