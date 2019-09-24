import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 5/8/2017.
 */
public class IETest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        File driverIE = new File("src/main/resources/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", driverIE.getAbsolutePath());
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSelenium3WithIE() throws Exception {
        driver.navigate().to("http://stirileprotv.ro/");
        Assert.assertTrue("The title was not as expected! ",driver.getTitle().contains("Stiri de Ultima Ora"));
    }

    @Test
    public void testGooglePageTitleInIEBrowser() throws InterruptedException {
        driver.navigate().to("http://www.google.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue("Page title doesn't match",strPageTitle.equalsIgnoreCase("Google"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
