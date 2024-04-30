package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.PageActions;
import com.vtiger.stepsdefinations.BaseDefinition;

public class LoginPage extends PageActions{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)    //3M
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="user_name")
	WebElement tb_uid;
	
	@FindBy(name ="user_password")
	WebElement tb_pass;
	
	@FindBy(name ="Login")
	WebElement btn_login;
	
	@FindBy(name ="login_theme")
	WebElement dp_theme;
	
	@FindBy(xpath ="//img[@src='include/images/vtiger-crm.gif']")
	WebElement img_logo;
	
	@FindBy(xpath ="//font[text()='Key Modules']")
	WebElement txt_KeyModules;
	
	
	/*1M
	String uid = "user_name";
	String pass = "user_password";
	String login = "Login";
	*/
	
	
	/*2M
	By uid = By.name("user_name");
	By pass = By.name("user_password");
	By login = By.name("Login");
	*/

	
	public void verifyTitle(String ExpectedTitle)
	{
		validate_Expected_Actual_Text(ExpectedTitle, driver.getTitle(), "Expected and Actual Title validated succefully");
	}
	
	public void verifyLogo()
	{
		ElementExist(img_logo ,"Logo displayed succefully");
	}
	
	public void verifyKeymoduletext()
	{
		ElementExist(txt_KeyModules ,"Text Key Modules displayed succefully");
	}
	
	public void verifyalltext(String txt)
	{
		try
		{
		   WebElement elm = driver.findElement(By.xpath("//*[contains(text(),'"+ txt +"')]"));
		   ElementExist(elm ,"Text "+ txt +" displayed succefully on login page");
		}
		catch(Exception e)
		{
			BaseDefinition.logger.fail("Element not found due to error "+ e.getMessage()+"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	}
	
	
	public void login(String userid , String pwd)
	{
		SetUsername(userid);
		SetPassword(pwd);
		ClickLogin();
	}
	
	
	public void login(String userid , String pwd , String theme)
	{
		SetUsername(userid);
		SetPassword(pwd);
		SelectTheme(theme);
		ClickLogin();
	}
	
	
	public void SetUsername(String userid )
	{
		//driver.findElement(By.name(uid)).clear();   1M
		//driver.findElement(By.name(uid)).sendKeys(userid);
		//driver.findElement((uid).clear();           2M
		//driver.findElement(uid).sendKeys(userid);
		//tb_uid.clear();                              3M
		//tb_uid.sendKeys(userid);
		SetText(tb_uid,userid,userid+" has been entered succefully in username field");
		
	}

	
	public void SetPassword (String pwd )
	{
		//driver.findElement(By.name(pass)).clear();  1M
	    //driver.findElement(By.name(pass)).sendKeys(userid);
		//driver.findElement((pass).clear();  2M
		//driver.findElement((pass).sendKeys(pwd);
		//tb_pass.clear();                      3M
		//tb_pass.sendKeys(pwd);
		SetText(tb_pass,pwd , pwd +" has been entered succefully in password field");
	}

	
	public void ClickLogin ()
	{
		//driver.findElement(By.name(login)).click(); 1M
		//driver.findElement(login).click();  2M
		//btn_login.click();                  3M
		clickElement(btn_login ,"login button clicked succefully");
	}
	
	public void SelectTheme (String theme)
	{
		SelectText(dp_theme, theme,theme+" selected from theme dropdown");	
	}
	
	
}
