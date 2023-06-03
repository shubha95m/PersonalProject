package org.personal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.personal.Page;

public class PageHelper extends Page {

    public PageHelper(WebDriver driver) {
        super(driver);
    }

    public void loadUrl() {
        driver.get("https://rc.alpha-sense.com");
    }

    public HomePage login() {
        loadUrl();
        UserNamePage userNamePage = PageFactory.initElements(driver, UserNamePage.class);
        userNamePage.sendKeys(userNamePage.userName, "alertfeedenabled.atester");
        PasswordPage passwordPage = userNamePage.clickOnNextButton();

        passwordPage.sendKeys(passwordPage.password, "AlphaAutoPass123!");
        return passwordPage.clickOnNextButton();
    }
}
