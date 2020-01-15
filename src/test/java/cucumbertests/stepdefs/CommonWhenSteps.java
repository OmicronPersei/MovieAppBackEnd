package cucumbertests.stepdefs;

import com.springboothackathon.SpringBootApplication;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest(classes = SpringBootApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonWhenSteps {

    @Autowired
    AppHttpClient appHttpClient;

    @LocalServerPort
    int port;

    int resCode;
    URL url;
    StringBuffer response;

    @When("^the client calls (.*) controller$")
    public void theClientCalls(String path) throws IOException {
        //url = new URL("http://localhost:" + port + "/" + path );
        url = new URL(appHttpClient.buildUrl() + "/" + path);
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
}
