package com.spicejet.ticket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPractice2 {
	WebDriver driver;
	@Parameters("browser")
	@Test(groups="sanity")
	public void test1(String browser)
	{
		System.out.println("practiceParallelExecution ===> "+Thread.currentThread().getId());
		WebDriver driver = null;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
	}
	@Parameters("browser")
	@Test(groups="sanity")
	public void test2(String browser)
	{
		System.out.println("practiceParallelExecution ===> "+Thread.currentThread().getId());
		WebDriver driver = null;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
	}
	@Parameters("browser")
	@Test
	public void test3(String browser)
	{
		System.out.println("practiceParallelExecution ===> "+Thread.currentThread().getId());
		WebDriver driver = null;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
	}

}
