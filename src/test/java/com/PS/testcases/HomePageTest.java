package com.PS.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PS.commons.BaseClass;
import com.PS.pageObjects.HomePage;
import com.PS.pageObjects.LoginPage;

public class HomePageTest extends BaseClass{

	LoginPage lp;
	HomePage hp;

	public HomePageTest() throws IOException
	{
		super();
	}

	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser)
	{
		launchApp(browser);
		lp=new LoginPage();
		hp=lp.logindata(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void clickOnPim() {
		hp.pimPage();
		
	}
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}

}
