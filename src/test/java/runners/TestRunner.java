package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:/Reports/htmlReport.html", "json:/Reports/jsonReports.json"},
		glue = "step_definitions",
		features = "./src/test/resources/Features/petStoreAPI.feature",
		tags = "@api",
		dryRun = false,
		publish = true
		)
public class TestRunner {

}
