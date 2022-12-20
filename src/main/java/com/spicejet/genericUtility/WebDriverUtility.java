package com.spicejet.genericUtility;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	WebDriver driver;
	public WebDriver launchApplication(String browser,long timeout,String url)
	{
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);

		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();

		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("enter valid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	/**
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any synchronized[java scripts actions]element
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI,and check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait  = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds 
	 * @param driver
	 * @param element
	 * @param pollingtime
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element,int pollingtime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingtime, TimeUnit.SECONDS);
		try {
			wait.wait(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any window based on window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to Alert window & click on Ok Button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to Frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to switch to Frame window based on webelement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * used to select the value from dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element ,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from dropdown based on visible Text 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element ,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to select the value from dropdown based on value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element ,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * used to place mouseover on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * pass Enter Key appertain in to Browser
	 * @param driver
	 */
	public void main(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to get the absolutepath of the file
	 * @param fileaddress
	 * @return
	 */
	public String getAbsolutePath(String fileaddress)
	{
		File f = new File(fileaddress);
		String absolutepath = f.getAbsolutePath();
		return absolutepath;
	}
	/**
	 * This method is used to verify whether the element is present or not
	 * @param ActualElement
	 * @param ExpectedElement
	 */
	public void verifyTheElementExisted(String ActualElement,String ExpectedElement)
	{
		if(ActualElement.equals(ExpectedElement))
		{
			System.out.println(ActualElement+"Element is present");
		}
		else
		{
			System.out.println(ActualElement+"Element is not present");
		}
	}
	/**
	 * This method is to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
		
	}
	
	public void waitTillElementTextInvisible(By currentMonthYearxpath,String text )
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.invisibilityOfElementWithText(currentMonthYearxpath, text));
	}
	
	
	

}

