package cucumbertests.stepdefs;

import com.springboothackathon.SpringBootApplication;
import cucumber.api.java.en.Given;
import org.junit.Before;
import org.springframework.boot.SpringApplication;

public class CommonSteps {

    @Before
    //@Given("^the server is running$")
    public void runServer()  {
        SpringApplication.run(SpringBootApplication.class);
    }
}
