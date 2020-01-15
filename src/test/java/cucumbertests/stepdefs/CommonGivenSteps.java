package cucumbertests.stepdefs;

import com.springboothackathon.SpringBootApplication;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

public class CommonGivenSteps {
    @Autowired
    AppHttpClient appHttpClient;

    /*@Given("^the server is running$")
    public void the_server_is_running()  {
        SpringApplication.run(SpringBootApplication.class);
    }*/

}
