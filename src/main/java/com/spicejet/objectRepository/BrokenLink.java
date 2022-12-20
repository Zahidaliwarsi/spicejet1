package com.spicejet.objectRepository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spicejet.genericUtility.WebDriverUtility;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverUtility webdriverutility = new WebDriverUtility();
		WebDriver driver = webdriverutility.launchApplication("chrome", 10, "https://www.amazon.in/");
		List<WebElement> listoflink = driver.findElements(By.xpath("//a"));
		for(int i = 0;i< listoflink.size();i++)
		{
			String url = listoflink.get(i).getAttribute("href");
			
				URL u =new URL(url);
				try {
					URLConnection urlConnection = u.openConnection();
					HttpURLConnection httpConnection=(HttpURLConnection) urlConnection;
					int statusCode = httpConnection.getResponseCode();
					if(statusCode!=200)
					{
						System.out.println("Broken Link"+url+"======>"+httpConnection.getResponseMessage());
					}
				}
				catch (IOException e) {
					System.out.println("something wrong with this URL ==> "+url);
				}
			
		}

	}

}
