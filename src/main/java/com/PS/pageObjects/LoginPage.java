package com.PS.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public LoginPage()
	{
		PageFactory.initElements(b.driver, this);
	}
	public String validateLoginPageTitle ()
	{
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
		return new HomePage();
		
	}

	
}
