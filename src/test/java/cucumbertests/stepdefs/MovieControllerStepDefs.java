package cucumbertests.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbertests.SpringIntegrationTest;
import org.springframework.boot.SpringApplication;
import springboothackathon.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MovieControllerStepDefs extends SpringIntegrationTest {

    int resCode;
    URL url;
    StringBuffer response;
    @Given("^the server is running$")
    public void the_server_is_running()  {
        SpringApplication.run(Application.class);
    }

    @When("^client calls movie controller$")
    public void client_calls_movie_controller() throws IOException {
        url = new URL("http://localhost:8080/movies");
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

    @Then("^client receives a list of all movies$")
    public void client_receives_a_list_of_all_movies() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
