package CucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature")
public class HomeControllerTest {

}
