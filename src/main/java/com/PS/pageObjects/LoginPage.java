package com.PS.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.PS.commons.BaseClass;

public class LoginPage extends BaseClass{
	
	BaseClass b=new BaseClass();
	
	@FindBy(xpath="//input[@name='username']")
	WebElement uname;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']")
	WebElement errmsg;
	
	public LoginPage()
	{
		PageFactory.initElements(b.driver, this);
	}
	public String validateLoginPageTitle () throws Exception
	{
		Thread.sleep(2000);
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public HomePage logindata(String username,String password)
	
	{
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginbtn.click();
//		String acterrormsg=errmsg.getText();
//		System.out.println("Error message shown after entering wrong user name and password     "+acterrormsg);
//		String expterrormsg="Invalid credentials";
//		Assert.assertEquals(acterrormsg, expterrormsg,"Error msg not getting");
		return new HomePage();
		
	}

	
}
