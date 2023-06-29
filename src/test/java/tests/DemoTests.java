package tests;

import org.personal.UserData;
import org.personal.Users;
import org.personal.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class DemoTests extends BaseTest {

    private HomePage homePage;
    private final UserData userData = Users.alertFeedEnabled;

    @BeforeMethod
    public void login() {
        pageHelper.loadUrl(prop.getValue("url"));
    }

    @Test
    public void testWithPropertiesData() {
        homePage = pageHelper.login(prop.getValue("username"), prop.getValue("password"));
        Assert.assertTrue(homePage.isSearchButtonDisplayed(),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done", "with properties data");
    }

    @Test
    public void testWithJsonData() {
        homePage = pageHelper.login(userData.getUserName(), userData.getPassword());
        Assert.assertTrue(homePage.isSearchButtonDisplayed(),
                "Search button is not displaying after login.");
        extentReportHelper.setStatus("pass", "login done", "with json data");
    }

}
