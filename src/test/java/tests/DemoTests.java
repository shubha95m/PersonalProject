package tests;

import org.personal.UserData;
import org.personal.Users;
import org.personal.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class DemoTests extends BaseTest{

    private HomePage homePage;
    private UserData userData = Users.alertFeedEnabled;

    @BeforeMethod
    public void login() {
        pageHelper.loadUrl(prop.getValue("url"));
    }

    @Test
    public void testWithHardCodedData() {
        homePage = pageHelper.login("alertfeedenabled.atester", "AlphaAutoPass123!");
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
    }

    @Test
    public void testWithPropertiesData() {
        homePage = pageHelper.login(prop.getValue("username"), prop.getValue("password"));
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
    }

    @Test
    public void testWithJsonData() {
        homePage = pageHelper.login(userData.getUserName(), userData.getPassword());
        Assert.assertTrue(homePage.isDisplayed(homePage.searchButton),
                "Search button is not displaying after login.");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
