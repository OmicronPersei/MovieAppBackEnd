package seleniumtests.homepageasserttitle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChromeHomePageTitleTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
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