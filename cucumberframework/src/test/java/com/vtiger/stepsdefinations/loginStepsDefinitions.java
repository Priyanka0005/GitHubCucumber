package com.vtiger.stepsdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.LoginPage;
import com.vtiger.pages.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepsDefinitions extends BaseDefinition{
	
	public PageObjectManager pageobjectmanager;
	
@Before
public void getScenarioName(Scenario scenario)
{
	TCName = scenario.getName();
	initiation();
	logger = extent.createTest(TCName);
}

@After
public void closeApp()
{
	extent.flush();
	
}

	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		
		if(driver==null)
		{
		  launchApp();
		}
		
		pageobjectmanager = new PageObjectManager(driver);
		    
	}
	
	@When("user can verify title")
	public void verifytitle() 
	{
		pageobjectmanager.getLoginPage().verifyTitle(dt.get(TCName).get("Title"));
	}
	
	@When("user can verify logo")
	public void verifylogo() 
	{
		pageobjectmanager.getLoginPage().verifyLogo();
	}
	
	@When("user can verify keymodule text")
	public void verifykeymoduletext() 
	{
		pageobjectmanager.getLoginPage().verifyKeymoduletext();
	}
	
	
	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		pageobjectmanager.getLoginPage().SetUsername(prop.getProperty("userid"));
		pageobjectmanager.getLoginPage().SetPassword(prop.getProperty("password"));
	}
	
	@When("click on login button")
	public void click_on_login_button() {
		//driver.findElement(By.name("Login")).click();
		pageobjectmanager.getLoginPage().ClickLogin();
	    
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		driver.findElement(By.linkText("Home")).isDisplayed();
	    	}
	@Then("user can click logout link")
	public void user_can_click_logout_link() {
		driver.findElement(By.linkText("Logout")).click();
	    
	}
	
	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {
		//driver.findElement(By.name("user_name")).sendKeys("admin232");
		//driver.findElement(By.name("user_password")).sendKeys("admin345");
		pageobjectmanager.getLoginPage().SetUsername("admin232");
		pageobjectmanager.getLoginPage().SetPassword("admin345");
	    
	}
	@When("user can validate error message on login page")
	public void user_can_validate_error_message_on_login_page() {
	    driver.findElement(By.xpath("//*[contains(text(),'You must specify')]")).isDisplayed();
	
	}
	
	@When("user enters userid as {string} and password as {string} credentials")
	public void user_enters_userid_as_and_password_as_credentials(String string, String string2) {
		//driver.findElement(By.name("user_name")).clear();
		//driver.findElement(By.name("user_name")).sendKeys(string);
		//driver.findElement(By.name("user_password")).clear();
		//driver.findElement(By.name("user_password")).sendKeys(string2); 
		pageobjectmanager.getLoginPage().SetUsername(string);
		pageobjectmanager.getLoginPage().SetPassword(string2);    
	}
	
	@When("user can verify existing text {string}")
	public void verify_all_text(String txt) {
		pageobjectmanager.getLoginPage().verifyalltext(txt);
		   
	}
	
	
}
