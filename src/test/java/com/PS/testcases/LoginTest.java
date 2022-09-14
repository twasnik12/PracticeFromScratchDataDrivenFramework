package com.PS.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PS.commons.BaseClass;
import com.PS.pageObjects.HomePage;
import com.PS.pageObjects.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage lp;
	HomePage hp;

	public LoginTest() throws IOException
	{
		super();
	}
	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser)throws Exception
	{
		launchApp(browser);
		lp = new LoginPage();
	}	
	@Test(priority=1)
	public void loginPageTitleTest() throws Exception
	{

		String actTitle=lp.validateLoginPageTitle();
		String exptTitle="OrangeHRM";
		Assert.assertEquals(actTitle, exptTitle,"Actual and Expected Title does not match");
		System.out.println("Assert condition is true first");
		String title=lp.validateLoginPageTitle();
		System.out.println("Title of the page........ "  +title);
	}
	
	@Test(priority=2)
	public void logoVerify()
	{
		boolean flag= lp.verifyLogo();
		System.out.println("Logo is verified ........ "  +flag);
	}

	@Test
	public void logintest()
	{

		hp=lp.logindata(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
