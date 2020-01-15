package seleniumtests.homepageasserttitle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EdgeHomePageTitleTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void assertTitle() {
        driver.get("https://spring-boot-hackathon-265015.appspot.com/");
        assertThat(driver.getTitle(), is("Movie Lookup"));
    }
}
