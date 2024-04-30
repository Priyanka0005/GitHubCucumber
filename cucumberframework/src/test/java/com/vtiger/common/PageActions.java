package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepsdefinations.BaseDefinition;

public class PageActions {

/*Wait:
	1. Implicit wait > global wait
	2. Explicit wait 
		 1. Thread.sleep > Static wait
		 2. WebDriverWait
		 3. FluentWait
		 
		 
*/
	private  WebDriver driver;
	WebDriverWait wait;
	
	public PageActions(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	}
	
	public String getScreenshot()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") +" src/test/java/com/vtiger/reports/screenshot"+ fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File SrcFile = ts.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(path);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			return path;	
	}
	
	public void validate_Expected_Actual_Text(String exp ,String act ,String msg) 
	{
		if(exp.equals(act))
		{
			BaseDefinition.logger.pass(msg);
		}
		else
		{
			BaseDefinition.logger.fail("Comparison failed because expected text is "+exp +" and actual was "+act +"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	

	}
	
	
	public void SetText(WebElement elm , String value , String msg)
	{
		try 
	  {	
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);
		BaseDefinition.logger.pass(msg);
		
	  }
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("Step failed due to error "+ e.getMessage()+"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	}
	
	public void SetText(By elm , String value)
	{
		try 
	  {	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(elm)));
		driver.findElement(elm);
		driver.findElement(elm).sendKeys(value);
	  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void SetText(String elm , String value)
	{
		try 
	  {	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm));
		driver.findElement(By.xpath(elm)).sendKeys(value);
	  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void clickElement(WebElement elm , String msg)
	{
		try 
	  {	
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
        BaseDefinition.logger.pass(msg);
		
	  }
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("Step failed due to error "+ e.getMessage()+"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	}
	
	public void ElementExist(WebElement elm , String msg)
	{
		try 
	  {	
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		 BaseDefinition.logger.pass(msg);
	  }
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("Element not found due to error "+ e.getMessage()+"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	}
	
	public void SelectText(WebElement elm , String value , String msg)
	{
		try 
	  {	
		wait.until(ExpectedConditions.visibilityOf(elm));
		Select sel = new Select(elm);
		sel.selectByVisibleText(value);
		elm.sendKeys(value);
        BaseDefinition.logger.pass(msg);
	  }
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefinition.logger.fail("Step failed due to error "+ e.getMessage()+"<a href='"+getScreenshot()+"'><span class='lable end-time'>Screenshot</span></a>");
		}
	}
	
}
