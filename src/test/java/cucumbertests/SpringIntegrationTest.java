package cucumbertests;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.springboothackathon.SpringBootApplication;


@ContextConfiguration(
        classes = SpringBootApplication.class,
        loader = SpringBootContextLoader.class)
@SpringBootTest(classes = SpringBootApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {


}


