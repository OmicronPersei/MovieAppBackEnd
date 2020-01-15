package cucumbertests.stepdefs;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class  AppHttpClient{

    private final String SERVER_URL = "http://localhost:";
    //private final String HOME_ENDPOINT = "/home";
    //private final String MOVIES_ENDPOINT = "/movies";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();


    public String buildUrl() {
        return SERVER_URL + port;
    }
    /*private String homeEndpoint() {
        return SERVER_URL + ":" + port + HOME_ENDPOINT;
    }

    private String moviesEndpoint() {
        return  SERVER_URL + ":" + port + MOVIES_ENDPOINT;
    }*/

        /*public int put(final String something) {
            return restTemplate.postForEntity(thingsEndpoint(), something, Void.class).getStatusCodeValue();
        }*/

        /*public Bag getContents() {
            return restTemplate.getForEntity(thingsEndpoint(), Bag.class).getBody();
        }*/

        /*public void clean() {
            restTemplate.delete(thingsEndpoint());
        }*/


}

