package tests;

import org.personal.page.HomePage;
import org.personal.page.PageHelper;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Test
public class DemoTests extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    public void login() {
        PageHelper pageHelper = new PageHelper(driver);
        homePage = pageHelper.login();
    }

    @Test
    public void test() {
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
