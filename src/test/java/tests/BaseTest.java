package tests;

import org.personal.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.personal.page.PageHelper;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected PageHelper pageHelper;
    protected PropertiesHelper prop;

    @BeforeSuite
    public void suiteSetup() {
        prop = new PropertiesHelper();
    }

    @BeforeTest
    public void testSetup() {

    }

    @BeforeMethod
    public void methodSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        pageHelper = new PageHelper(driver);
    }

    @AfterTest
    public void posTest() {

    }

    @AfterSuite
    public void postSuite() {

    }
}
