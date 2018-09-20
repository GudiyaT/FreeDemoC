package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest  extends Testbase{
	LoginPage login;
	HomePage home;
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login =new LoginPage();
		
	}
	
	@Test(priority=1)
	
	public void CRMLogoTest()
	{
		boolean flag = login.boolenValidateCRMLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=2)
	
	public void logintest()
	{
		home=login.Login(prop.getProperty("username"),prop.getProperty("passsword"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
