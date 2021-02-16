package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//This is the runner class from where we will run the tags that are selected here
// The reports are generated in 3 different formats : HTML JSON & XML
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"Features"},
		glue={"StepDefinitions"},
		plugin={"pretty", "html:target/reports/HTMLReports.html",
				"pretty", "json:target/reports/cucumber.json",
				"pretty",  "junit:target/reports/cucumber.xml"},
				tags = "@ExpediaTestFeature" ,  //@DuckDuckGoTestFeature//@ExpediaTestFeature
		        monochrome = true 
		)
public class Runner {

}
