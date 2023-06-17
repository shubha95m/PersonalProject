package tests;

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
        pageHelper.loadUrl(prop.getValue("url"));
    }

    @Test
    public void testWithHardCodedData() {
        homePage = pageHelper.login("alertfeedenabled.atester", "AlphaAutoPass123!");
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done", "with hardcode data");
    }

    @Test
    public void testWithPropertiesData() {
        homePage = pageHelper.login(prop.getValue("username"), prop.getValue("password"));
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done", "with properties data");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
