package cucumbertests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/home/moviecontroller.feature", plugin = {"pretty", "json:target/cucumber-report.json"})
public class MovieControllerTest {
}
