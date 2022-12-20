package com.spicejet.ticket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeClass {
	@Test(groups="sanity")
	public  void calenderHandle(String[]args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://rmgtestingserver:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Calendar")).click();
		driver.findElement(By.xpath("//img[@title='Open Calendar...']")).click();
		String yearMonth = driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();
		String currentYear = yearMonth.split(" ")[1];
		String currentMonth = yearMonth.split(" ")[0];
		//System.out.println(currentYear+" "+currentMonth);
		String requiredYear = "2023";
		String requiredMonth = "March";
		String requiredDate = "19";
		while(!(currentYear.equals(requiredYear) && currentMonth.equals(requiredMonth)))
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			driver.findElement(By.xpath("//td[@class='calHdr']/a[3]")).click();
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']//b"), yearMonth));
			yearMonth = driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();
			currentYear = yearMonth.split(" ")[1];
			currentMonth = yearMonth.split(" ")[0];
		}
		driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click();
		String text = driver.findElement(By.xpath("//td[@class='calendarNav']")).getText();
		System.out.println(text);
	}

}
