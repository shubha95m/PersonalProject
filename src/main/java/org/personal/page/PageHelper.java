package org.personal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.personal.Page;

public class PageHelper extends Page {

    UserNamePage userNamePage = PageFactory.initElements(driver, UserNamePage.class);

    public PageHelper(WebDriver driver) {
        super(driver);
    }

    public void loadUrl(String url) {
        driver.get(url);
    }

    public HomePage login(String userName, String password) {
        userNamePage.sendKeys(userNamePage.userName, userName);
        PasswordPage passwordPage = userNamePage.clickOnNextButton();

        passwordPage.sendKeys(passwordPage.password, password);
        return passwordPage.clickOnNextButton();
    }
}
