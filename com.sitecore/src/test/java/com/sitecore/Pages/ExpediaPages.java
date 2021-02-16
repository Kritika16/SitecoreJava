/**
 * 
 */
package com.sitecore.Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kritika
 * This Class will store all the locators of Expedia Website
 * Page Object Model has been used to write this: Could also use the page factory method of writing the xpaths  
 */
public class ExpediaPages {

	// Initialise the Webdriver and the WebDriverWait to use it in the methods Below
	WebDriver driver;
	WebDriverWait wait;
	// all the xpaths that has been used in the methods has been written first so that if there is any change it can directly be changed only at one place
	By SearchButton = By.xpath("//button[contains(text(),'Search')]");
	By InputDestination = By.xpath("//button[@class='uitk-faux-input']");
	By SearchDestination =By.id("location-field-destination");
	By SelectDestination = By.xpath("//*[contains(text(),\"Manhattan\")]");
	By AddFlightCheckBox = By.id("add-flight-switch");
	By InputLeavingFrom  = By.xpath("//button[@data-stid=\"location-field-origin-menu-trigger\"]");
	By SearchLeavingFrom = By.id("location-field-origin");
	By SelectLeavingFrom = By.xpath("//*[contains(text(),\"Brussels (BRU - All Airports)\")]");
	By CheckInCalendar = By.id("d1-btn");
	By DoneCalendar = By.xpath("//button//span[contains(text(),'Done')]");
	By TravellerButton = By.id("adaptive-menu");
	By DoneTaveller = By.xpath("//button[contains(text(),'Done')]");
	By SearchFinal =By.xpath("//button[contains(text(),'Search')]");
	By ResultsPage = By.xpath("//*[@class=\"results\"]");
	By MonthName = By.xpath("//div[@class=\"uitk-date-picker-menu-months-container\"]//h2");
	By MonthNext = By.xpath("//div[@class=\"uitk-flex uitk-flex-justify-content-space-between uitk-date-picker-menu-pagination-container\"]//button[2]");
	By AllDatesForSelectedMonth = By.xpath("//div[@class=\"uitk-calendar\"]//div[2]/div[1]/table[1]/tbody[1]/tr/td/button[1]");
	By IncreaseNoOfAdults = By.xpath("//*[contains(@aria-labelledby,'uitk-step-increase-adults')]");
	By DecreaseNoOfAdults = By.xpath("//*[contains(@aria-labelledby,'uitk-step-decrease-adults')]");
	By IncreaseChildren = By.xpath("//*[contains(@aria-labelledby,'uitk-step-increase-children')]");

	//Constructor to initalise the object created
	public ExpediaPages(WebDriver driver) {
		//This is to initialise the webdriver in this class 
		//this.driver used to point the driver of this class
		this.driver =driver;
	}

	public void waitTillPageLoads() {
		// This method is to verify the Page has successfully loaded and now the test can start running	
		// Wait till 30 seconds till the expected condition is fulfilled
		wait = new WebDriverWait(driver, 30);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(SearchButton));
		// isdisplayed() method returns value in boolean hence if true the element is visible and if false vice versa 
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("===== Page Loaded Successfully======");
		} else {
			System.out.println("===== Page Unavailable======");
		}
	}

	public void  enterDestination() {

		// This method enters the destination : 
		// This method can also be parameterised to accept any destination
		// Here since we are just writing test for one destination hence not needed
		
		//wait for 30 sec for the text box to be visible to enter the Destination
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(InputDestination));
		//Click on the textbox to type in the destination
		driver.findElement(InputDestination).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchDestination));
		//Type in the destination
		driver.findElement(SearchDestination).sendKeys("New York");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDestination));
		//Select the destination from the dropdown
		driver.findElement(SelectDestination).click();
	}

	public void addFlightOption() {
		//Click on check box to add the flight as well
		driver.findElement(By.id("add-flight-switch")).click();
	}

	public void enterLeavingFrom() {
		
		// This method enters the Leaving From place 
		// This method can also be parameterised to accept any Leaving From place
		// Here since we are just writing test for one Leaving From place hence not needed
		
		//wait for 30 sec for the text box to be visible to enter the Leaving From 
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(InputLeavingFrom));
		//Click on the textbox to type in the destination
		driver.findElement(InputLeavingFrom).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchLeavingFrom));
		//Type in the Leaving From Place
		driver.findElement(SearchLeavingFrom).sendKeys("Brussels");
		//Select the Leaving Place from the dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(SelectLeavingFrom));
		driver.findElement(SelectLeavingFrom).click();
	}

	public void clickCheckInCalendar() throws InterruptedException {
		// Click on the calendar box to select dates
		driver.findElement(CheckInCalendar).click();
	}

	public void selectMonth(String Month) {

		// While loop to select the correct month: If month matches the value then exit the loop else click on the next month button to go on to the next month
		while (true) {
			String text = driver.findElement(MonthName).getText();
			if (text.equals(Month)) {
				break;
			} else {
				driver.findElement(MonthNext).click();
			}
		}

	}

	public void selectDate(String Date) {
		
		
		// Once the month is selected : Get all the dates visible for that month
		// If the dates are not enable (Past Date) the test fails
		List<WebElement> allDates = driver.findElements(AllDatesForSelectedMonth);
		for (WebElement ele:allDates) {			

			String dateFrom = ele.getAttribute("data-day");
			if (dateFrom.equals(Date)) {
				if(ele.isEnabled()) {
				ele.click();			
				break;
				}
				else {
					Assert.fail("--------Please Dont Select Past Dates---------");
					break;	
				}
					
			}
		}
	}

	public void clickDoneCalendar() {
		//Clicks on the done of the calendar
		driver.findElement(DoneCalendar).click();
	}

	public void clickSelectTravellers() {
		//Clicks on choose traveller button
		driver.findElement(TravellerButton).click();
	}

	public void clickSelectNoOfAdults(Integer Adult) {
		//Selects the number of adults 
		// By default the number of adults is 2: So here if the number if adults is less than 2 then it clicks on the decrease button : else it increases the number
		// If the nuber of adults is 2 it leaves it as is
		if(Adult>2) {
			for (int i = 2; i < Adult; i++) {
				driver.findElement(IncreaseNoOfAdults).click();
				System.out.println("Selected Adults");
			}
		}
		else
		{
			driver.findElement(DecreaseNoOfAdults).click();
			System.out.println("Selected Adults Decrease");
		}
	}
	public void clickSelectNoOfKidsAndAge(Integer Children, Integer ChildAge) {
		// This method selects the number of children and their ages at the same time
		for (int i = 0; i < Children; i++) {
			driver.findElement(IncreaseChildren).click();
			WebElement Age = driver.findElement(By.id("child-age-input-0-"+i));
			Select CAge = new Select(Age);
			CAge.selectByIndex(ChildAge);
		}
	}

	public void clickDoneForTravellers() {
		//Clicks on the done button after selecting the number of travellers
		driver.findElement(DoneTaveller).click();
	}

	public void SearchFinal() {
		//Clicks on the final search button
		driver.findElement(SearchFinal).click();
	}

	public void verifySearch() {
		// Waits for 30 sec for the results page to be visible and verifies the results page has loaded successfully
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ResultsPage));
		boolean  status = element.isDisplayed();
		if (status) {
			System.out.println("===== Results Page Loaded Successfully======");
		} else {
			System.out.println("===== Results Page Unavailable======");
		}
	}

}
