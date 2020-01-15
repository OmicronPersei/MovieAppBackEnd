package cucumbertests.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumbertests.SpringIntegrationTest;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.boot.SpringApplication;

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

    @When("^the client calls home controller$")
    public void the_client_calls_home_controller() throws IOException {
        url = new URL("http://localhost:8080/home");
        String readLine = null;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
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
}