package cucumbertests.stepdefs;

import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonWhenSteps {

    int resCode;
    URL url;
    StringBuffer response;

    @When("^the client calls (.*) controller$")
    public void theClientCalls(String path) throws IOException {
        url = new URL("http://localhost:8080/" + path);
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
