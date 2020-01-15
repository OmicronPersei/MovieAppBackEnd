package cucumbertests.stepdefs;

import cucumber.api.java.en.Given;
import org.springframework.boot.SpringApplication;
import springboothackathon.Application;

public class CommonGivenSteps {

    @Given("^the server is running$")
    public void the_server_is_running()  {
        SpringApplication.run(Application.class);
    }

}
