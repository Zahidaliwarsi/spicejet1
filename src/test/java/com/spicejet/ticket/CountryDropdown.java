package com.spicejet.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryDropdown {
	@Test(groups="sanity")
	public void searchBox(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement element = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(element);
		List<String> al = new ArrayList<String>();
		
		List<WebElement> a = s.getOptions();
		
		for(WebElement web:a)
		{
			al.add(web.getText());
		}
		
		Collections.sort(al);
		System.out.println(al);
	}

}
