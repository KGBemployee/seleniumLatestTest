import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Alex on 4/17/2017.
 */
public class ChromeTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/win/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
            driver = new ChromeDriver(options);
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/mac/chromedriver");
            driver = new ChromeDriver();
        } else if (os.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/linux/chromedriver");
            driver = new ChromeDriver();
        } else {
            throw new Exception("Unhandled os! Must be Linux, MacOs or Windows");
        }
    }

    @Test
    public void testSelenium3WithChrome() throws Exception {
        driver.get("http://stirileprotv.ro/");
        System.out.println(driver.getTitle());
        Assert.assertTrue("The title was not as expected! ",driver.getTitle().contains("Stiri de Ultima Ora"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
