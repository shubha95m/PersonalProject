package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class DemoTests {

    private WebDriver driver;

    @BeforeClass()
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void test() {
        driver.get("https://rc.alpha-sense.com");


        driver.findElement(By.name("username")).sendKeys("alertfeedenabled.atester");
        driver.findElement(By.id("next-step")).click();
        driver.findElement(By.name("password")).sendKeys("AlphaAutoPass123!");
        driver.findElement(By.xpath(".//button[@data-testid='loginSubmitButton']")).click();

        WebElement searchButton = driver.findElement(By.xpath(".//button[@data-testid='searchButton']"));

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(searchButton));

        Assert.assertTrue(searchButton.isDisplayed(), "Search button is not visible after signing in.");
        searchButton.click();

    }

    @AfterClass
    public void cleanUp() {
        driver.close();
    }

}
