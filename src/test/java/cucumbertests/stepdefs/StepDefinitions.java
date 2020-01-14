package cucumbertests.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumbertests.SpringIntegrationTest;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.boot.SpringApplication;
import springboothackathon.Application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StepDefinitions extends SpringIntegrationTest {

    int resCode;
    URL url;
    StringBuffer response;
    HttpURLConnection con;

    @Given("^the server is running$")
    public void the_server_is_running()  {
        SpringApplication.run(Application.class);
    }

    @When("^the client performs a GET call on home controller$")
    public void theClientPerformsAGETCallOnHomeController()  throws IOException {
        url = new URL("http://localhost:8080/home");
        String readLine = null;
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        resCode = con.getResponseCode();



        if (resCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    @Then("^the client gets a success response$")
    public void the_client_gets_a_success_response() {
        assertThat(resCode).isEqualTo(200);
    }

    @Then("^the client receives the response string Greetings from Spring Boot!$")
    public void theClientReceivesTheResponseStringGreetingsFromSpringBoot() {
        assertThat(response.toString()).isEqualTo("Greetings from Spring Boot!");
    }

    @Then("^the client should be connected to the correct URL$")
    public void theClientShouldBeConnectedToTheCorrectURL() {
        assertThat(con.getURL().toString()).isEqualTo("http://localhost:8080/home");
    }

    @Then("^the client should be performing a GET call$")
    public void theClientShouldBePerformingAGETCall() {
        assertThat(con.getRequestMethod()).isEqualTo("GET");
    }
}