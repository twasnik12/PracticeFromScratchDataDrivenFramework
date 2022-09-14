package com.PS.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.commons.BaseClass;

public class HomePage extends BaseClass {
	
	BaseClass b=new BaseClass();
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	WebElement clkpim;
	
	@FindBy(xpath="//header[@class='oxd-topbar']//li[3]")
	WebElement addemp;
	
//	@FindBy(css=".oxd-topbar-body-nav-tab.--visited")
//	WebElement addemp;
	
	
	public HomePage()
	{
		PageFactory.initElements(b.driver, this);
	}
	
	public void pimPage()
	{
		clkpim.click();
		addemp.click();
		
	}
	
	

}
