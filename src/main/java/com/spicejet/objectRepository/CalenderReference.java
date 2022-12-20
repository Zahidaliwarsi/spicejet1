package com.spicejet.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.spicejet.genericUtility.JavaUtility;
import com.spicejet.genericUtility.WebDriverUtility;

public class CalenderReference {
	@FindBy(xpath="//td[@class='calHdr']/a[3]") private WebElement nextButton;
	@FindBy(xpath="//td[@class='calHdr']//b") private WebElement currentMonthYearxpath;
	String currentMonthYearTextXpath = "//td[@class='calHdr']//b";
	
	
	private By stringToBy(String s)
	{
		return By.xpath(s);
	}
	
	public void handleCalender(WebDriver driver, JavaUtility javautility,WebDriverUtility webdriverutility,String reqMonth,String reqYear,String reqDate)
	{
		int requiredMonth = javautility.getMonthInMMFormat(reqMonth);
		int requiredyear = (Integer) javautility.stringToAnyDataType(reqYear,"int");
		//String currentMonthYear=getCurrentMonthText(driver);
		String currentMonthYear = currentMonthYearxpath.getText();
		String[] monthYearArr = javautility.splitString(currentMonthYear," ");
		 int currentMonth = javautility.getMonthInMMFormat(monthYearArr[0]);
		 int currentYear = (Integer) javautility.stringToAnyDataType(monthYearArr[1], "int");
		 
		 while(requiredMonth>currentMonth || requiredyear>currentYear)
		 {
			 nextButton.click();
			 webdriverutility.waitTillElementTextInvisible(stringToBy(currentMonthYearTextXpath), currentMonthYear);
			 currentMonthYear = currentMonthYearxpath.getText();
			 monthYearArr = javautility.splitString(currentMonthYear," ");
			 currentMonth = javautility.getMonthInMMFormat(monthYearArr[0]);
			 currentYear = (Integer) javautility.stringToAnyDataType(monthYearArr[1], "int");
		 }
		
	}

}
