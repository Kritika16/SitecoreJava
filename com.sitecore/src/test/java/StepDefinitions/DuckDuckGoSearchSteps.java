package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sitecore.Pages.DuckDuckGoPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.ConfigReader;
import library.UtilityScreenShot;

/**
 * @author Kritika
 * This Class implements the Feature file steps 
 * Names of the classes have been chosen that can explain itself
 */

public class DuckDuckGoSearchSteps {
	
	WebDriver driver=null;
	WebDriverWait wait;
	ConfigReader config;
	DuckDuckGoPages DDGPages;

	
	@Before
	public void OpenChrome() {
	//Initialize the objects and opens the chrome driver	
	config = new ConfigReader();
	System.setProperty("webdriver.chrome.driver",config.getChromePath());
	driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	DDGPages = new DuckDuckGoPages(driver);
	
	}
	
	@Given("Open DuckDuckGo website")
	public void open_duck_duck_go_website() {
		
		driver.get(config.getDuckDuckGoURL());	
	}

	@And("Page Loaded Successfully")
	public void page_loaded_successfully() {
		
		DDGPages.verifyPageHasLoaded();
	}

	@When("^Search For a (.*)$")
	public void search_for_a_place(String Place) {
		DDGPages.searchForPlace(Place);
		DDGPages.clickSearchButton();
	}

	@Then("Verify User is navigated to search results")
	public void user_is_navigated_to_search_results() {
		DDGPages.verifyResults();
	}


	@And("^Take A (.*)$")
	public void take_a_screen_shot(String Screenshot)  {
		UtilityScreenShot.captureScreenShot(driver, Screenshot);
	}
	
	@After
	public void Teardown() {
		driver.quit();
		
	}
}
