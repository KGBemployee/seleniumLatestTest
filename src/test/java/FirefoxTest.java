import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alex on 4/17/2017.
 */
public class FirefoxTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/win/geckodriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/mac/geckodriver");
        } else if (os.contains("nix")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/linux/geckodriver");
        } else {
            throw new Exception("Unhandled os! Must be Linux, MacOs or Windows");
        }

        driver = new FirefoxDriver();
    }

    @Test
    public void testSelenium3WithFirefox() throws Exception {
        driver.get("http://stirileprotv.ro/");
        Assert.assertTrue("The title was not as expected! ", driver.getTitle().contains("Stiri de ultima ora"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
