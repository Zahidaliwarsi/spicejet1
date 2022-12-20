package com.spicejet.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.genericUtility.WebDriverUtility;

public class SearchFlight {
	@FindBy(xpath="//div[text()='round trip']/../preceding-sibling::div/*[name()='svg']")  private WebElement roundTrip;
	@FindBy(xpath="//div[@data-testid='to-testID-origin']/div[1]/div[2]/input") private WebElement oiginTextBox;
	@FindBy(xpath="//div[text()='Bengaluru']") private WebElement bengaluruAirport;
	@FindBy(xpath="//div[@data-testid='to-testID-destination']/div[1]/div[2]/input") private WebElement destinationTextBox;
	@FindBy(xpath="//div[text()='Delhi']") private WebElement delhiAirport;
	@FindBy(xpath="//div[@data-testid='departure-date-dropdown-label-test-id']//*[name()='svg']") private WebElement departureDateDropdown;
	@FindBy(xpath="//div[@data-testid = 'undefined-month-December-2022']/div[1]/div[contains(text(),'%s')]/../following-sibling::div[2]//div[text()='8']") private WebElement departureDate;
	@FindBy(xpath="//div[@data-testid='return-date-dropdown-label-test-id']/div[2]/div[2]/*[name()='svg']") private WebElement returnDatedropdown;
	@FindBy(xpath="//div[@data-testid='undefined-calendar-picker']/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[4]") private WebElement returnDate;
	@FindBy(xpath="//div[text()='Passengers']") private WebElement passengersDropdown;
	@FindBy(xpath="Children-testID-plus-one-cta") private WebElement childrenId;
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']") private WebElement searchFlightBtn;
	String partialxpath="//div[@data-testid = 'undefined-month-December-2022']/div[1]/div[contains(text(),'December')]/../following-sibling::div[2]//div[text()='%s']";
	
	public SearchFlight(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRoundTrip()
	{
		roundTrip.click();
		
	}
	public void selectPlaceofOriginTextBox()
	{
		oiginTextBox.click();
		bengaluruAirport.click();
	}
	public void selectPlaceinDestinationTextBox()
	{
		destinationTextBox.click();
		delhiAirport.click();
	}
	public void selectDepartureDate(WebDriver driver) 
	{
		//String xpath = String.format(partialxpath, replaceddata1);
		//departureDateDropdown.click();
		driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[2]/div[2]/*[name()='svg']")).click();
		//driver.findElement(By.xpath(xpath)).click();
		
		//driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[3]/div[2]/div/div[1]/div/div[3]/div[1]/div[5]/div/div")).click();
	}
	
	public void clickOnreturnDatedropdown(WebDriver driver) throws InterruptedException
	{
		returnDatedropdown.click();
		Thread.sleep(1000);
		returnDate.click();
		//driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[4]")).click();
		
	}
	public void selectPassenger()
	{
		
		passengersDropdown.click();
		
		childrenId.click();
		
	}
	public void clickOnSearchFlightButton()
	{
		
		searchFlightBtn.click();
	}
	public void clickOnDate(WebDriver driver)
	{
		String listmonthyear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj']/div")).getText();
		String currentMonth = listmonthyear.split(" ")[0];
		String currentyear = listmonthyear.split(" ")[1];
		String requiredmonth = "March";
		String requiredYear = "2022";
		while(!(currentMonth.equals(requiredmonth) && currentyear.equals(requiredYear)))
		{
			driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']//ancestor::div[@class='css-1dbjc4n r-19h5ruw r-136ojw6']/div/div[2]/div[2]/div[1]/*[name()='svg']")).click();
			listmonthyear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj']/div")).getText();
			currentMonth = listmonthyear.split(" ")[0];
			currentyear = listmonthyear.split(" ")[1];
			
		}
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(listmonthyear)));
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']//div[text()='9']")).click();
	}
}
