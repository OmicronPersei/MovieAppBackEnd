package cucumbertests;

import com.springboothackathon.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(
        classes = SpringBootApplication.class,
        loader = SpringBootContextLoader.class)
@SpringBootTest(classes = SpringBootApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {


}



