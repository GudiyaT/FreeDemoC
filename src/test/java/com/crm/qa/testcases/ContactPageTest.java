package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends Testbase {
	
	LoginPage login;
	HomePage home;
	TestUtil testutil;
	ContactPage contactpage;
	String sheetName ="Contacts";
	public ContactPageTest() 
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
	     testutil.switchToFrame();
		contactpage= home.clickOnContactLink();
    }

/*	@Test(priority=1)
	
	public void verifyContactPagelabel()
	
	{
      testutil.switchToFrame();
     Assert.assertTrue(contactpage.verifyContactlabel());
	} */
	
	/*@Test(priority=2)
	
	public void verifyNewContact()
	
	{
    
		home.clickonNewContactLink();
		contactpage.createnewContact("Mr."," Tom", "Jerry", "ITC");
		
	} */

	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException
	{
		Object[][] data =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1 ,dataProvider="getCRMTestData")
	
	public void verifyCreateNewContact(String title,String FirrstNme,String MiddleNme , String Com)
	{
		
		home.clickonNewContactLink();
		contactpage.createnewContact(title, FirrstNme, MiddleNme, Com);
		
	}
	
	
	

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


	

}
