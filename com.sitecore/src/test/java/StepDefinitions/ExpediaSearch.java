package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sitecore.Pages.ExpediaPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.ConfigReader;

/**
 * @author Kritika
 * This Class implements the Feature file steps 
 * Names of the classes have been chosen that can explain itself
 */

public class ExpediaSearch {

	WebDriver driver=null;
	WebDriverWait wait;
	ConfigReader config;
	ExpediaPages exPages;

	@Before
	public void OpenChrome() {
		//Initialize the objects and opens the chrome driver
		config = new ConfigReader();
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		exPages = new ExpediaPages(driver);
	}


	@Given("Navigate To Expedia Website")
	public void navigate_to_expedia_website() {

		driver.get(config.getExpediaURL());
	}

	@And("Expedia Website Loaded Successfully")
	public void expedia_website_loaded_successfully() {

		exPages.waitTillPageLoads();
	}

	@When("Search For an Accomodation in NewYork")
	public void search_for_an_accomodation_in_new_york() {

		exPages.enterDestination();
	}

	@And("Click on Add Flight Option")
	public void click_on_add_flight_option() {
		exPages.addFlightOption();
	}

	@And("Add a Flight From Brussels To NewYork")
	public void add_a_flight_from_brussels_to_new_york() {
		exPages.enterLeavingFrom();
	}

	@And("Select Travel Dates  {string}  {string}  {string}  {string}")
	public void select_travel_dates_febuary_march(String FromDate, String FromMonth, String ToDate, String ToMonth) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		exPages.clickCheckInCalendar();
		exPages.selectMonth(FromMonth);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		exPages.selectDate(FromDate);
		exPages.selectMonth(ToMonth);
		exPages.selectDate(ToDate);		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		Thread.sleep(1000);
		exPages.clickDoneCalendar();
		Thread.sleep(1000);
	}

	@And("Select No of {int} and {int} and {int}")
	public void select_no_of_and(Integer Adult, Integer Children, Integer ChildAge) {
		
		driver.findElement(By.id("adaptive-menu")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		exPages.clickSelectNoOfAdults(Adult);
		exPages.clickSelectNoOfKidsAndAge(Children, ChildAge);
		exPages.clickDoneForTravellers();
		exPages.SearchFinal();		
	}

	@Then("Verify results page contains Travel Option")
	public void verify_results_page_contains_travel_option() {
		
		exPages.verifySearch();
	}

	@After
	public void Teardown() {
		
		driver.quit();
	}

}
