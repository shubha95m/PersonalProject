package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.personal.helpers.ExtentReportHelper;
import org.personal.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.personal.page.PageHelper;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;

public class BaseTest {

    protected static WebDriver driver;
    protected static PageHelper pageHelper;
    protected static PropertiesHelper prop;
    protected static ExtentReportHelper extentReportHelper;
    private static String testName;

    @BeforeSuite
    public void suiteSetup() {
        prop = new PropertiesHelper();
    }

    @BeforeTest
    public void testSetup() {

    }

    @BeforeClass
    public void classSetUp() {

    }

    @BeforeMethod
    public void methodSetup(ITestResult result) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageHelper = new PageHelper(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        testName = result.getTestClass().getName() + "_" + result.getMethod().getMethodName();
        extentReportHelper = new ExtentReportHelper(testName, driver);
    }

    @AfterMethod
    public void postMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void posTest() {
        extentReportHelper.flush();
    }

    @AfterSuite
    public void postSuite() {

    }
}
