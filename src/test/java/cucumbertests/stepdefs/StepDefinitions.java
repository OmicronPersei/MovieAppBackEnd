package cucumbertests.stepdefs;

import com.springboothackathon.SpringBootApplication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumbertests.SpringIntegrationTest;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Java6Assertions.assertThat;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = SpringBootApplication.class)
public class StepDefinitions extends SpringIntegrationTest {

    @Autowired
    AppHttpClient appHttpClient;

    int resCode;
    StringBuffer response;

    @Then("^the client gets a success response$")
    public void the_client_gets_a_success_response() {
        assertThat(resCode).isEqualTo(200);
    }

    @Then("^the client receives the response string Greetings from Spring Boot!$")
    public void theClientReceivesTheResponseStringGreetingsFromSpringBoot() {
        assertThat(response.toString()).isEqualTo("Greetings from Spring Boot!");
    }
}