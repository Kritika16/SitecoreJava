/**
 * 
 */
package com.sitecore.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kritika
 * This Class will store all the locators of DuckDuckGo Website
 * Page Object Model has been used to write this: Could also use the page factory method of writing the xpaths  
 *  
 */
public class DuckDuckGoPages {

	// Initialise the Webdriver and the WebDriverWait to use it in the methods Below
	WebDriver driver;
	WebDriverWait wait;	
	// all the xpaths that has been used in the methods has been written first so that if there is any change it can directly be changed only at one place
	By InputHomePage = By.xpath("//input[@id='search_form_input_homepage']");
	By InputPlaceName = By.id("search_form_input_homepage");
	By SearchButton = By.id("search_button_homepage");
	By ResultsPage = By.id("links");

	//Constructor to initalise the object created
	public DuckDuckGoPages(WebDriver driver) {
		//This is to initialise the webdriver in this class 
		//this.driver used to point the driver of this class
		this.driver=driver;
	}


	public void verifyPageHasLoaded() {
		// This method is to verify the Page has successfully loaded and now the test can start running	
		//Wait till 30 seconds till the expected condition is fulfilled
		wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(InputHomePage));
		// isdisplayed() method returns value in boolean hence if true the element is visible and if false vice versa 
		boolean  status = element.isDisplayed();
		if (status) {
			System.out.println("===== Page Loaded Successfully======");
		} else {
			System.out.println("===== Page Unavailable======");
		}
	}


	public void searchForPlace(String Place) {
		//This method Types in the Name of the place to be searched		
		driver.findElement(InputPlaceName).click();
		driver.findElement(InputPlaceName).sendKeys(Place);
	}


	public void clickSearchButton() {
		//This method clicks on the search button		
		driver.findElement(SearchButton).click();
	}

	public void verifyResults() {
		// This method waits till the search page is loaded. 
		// Waits for 30 seconds for the element to be visible

		wait=new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ResultsPage));
		// isdisplayed() method returns value in boolean hence if true the element is visible and if false vice versa 
		boolean  status = element.isDisplayed();
		if (status) {
			System.out.println("===== Results Page Loaded Successfully======");
		} else {
			System.out.println("===== Results Page Unavailable======");
		}
	}
}
