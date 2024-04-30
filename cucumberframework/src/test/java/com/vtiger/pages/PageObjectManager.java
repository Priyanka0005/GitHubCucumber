package com.vtiger.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		
	}

	public LoginPage loginpage;
	public HomePage homePage;
	public NewLeadPage newleadpage;
	
	
	public LoginPage getLoginPage(){

		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;

	}
	
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	
	public NewLeadPage getNewLeadPage(){

		return (newleadpage == null) ? newleadpage = new NewLeadPage(driver) : newleadpage;

	}
	
	
	
	
}
