package cucumbertests.stepdefs;

import com.springboothackathon.SpringBootApplication;
import cucumber.api.java.en.Given;
import org.springframework.boot.SpringApplication;

public class CommonGivenSteps {

    @Given("^the server is running$")
    public void the_server_is_running()  {
        SpringApplication.run(SpringBootApplication.class);
    }

}
