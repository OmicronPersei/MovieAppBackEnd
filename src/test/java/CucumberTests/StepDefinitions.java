package CucumberTests;

import cucumber.api.java.en.When;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StepDefinitions extends SpringIntegrationTest {
    @When("^the client calls home controller$")
    public void getStuff() throws IOException {
        URL url = new URL("http://localhost:8080/home");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.flush();
        out.close();
    }
}
