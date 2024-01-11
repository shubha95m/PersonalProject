package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.personal.UserData;
import org.personal.Users;
import org.personal.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class DemoTest2 extends BaseTest {

    private HomePage homePage;
    private final UserData userData = Users.alertFeedEnabled;

    @BeforeMethod
    public void login() {
        driver.get("https://google.com");
        pageHelper.loadUrl(prop.getValue("url"));
    }

    @Description("Checking allure description")
    @Test
    public void testWithHardCodedData() {
        homePage = pageHelper.login("alertfeedenabled.atester", "AlphaAutoPass123!");
        Assert.assertTrue(homePage.isSearchButtonDisplayed(),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done with hardcode data");
    }

    @Test
    public void testWithPropertiesData() {
        homePage = pageHelper.login(prop.getValue("username"), prop.getValue("password"));
        Assert.assertTrue(homePage.isSearchButtonDisplayed(),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
