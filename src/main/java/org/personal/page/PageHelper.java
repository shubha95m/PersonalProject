package org.personal.page;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.personal.Page;

public class PageHelper extends Page {

    UserNamePage userNamePage = PageFactory.initElements(driver, UserNamePage.class);

    public PageHelper(WebDriver driver) {
        super(driver);
    }

    public void loadUrl(String url) {
        Allure.step("Opening " + url);
        driver.get(url);
    }

    public HomePage login(String userName, String password) {
        userNamePage.sendKeys(userNamePage.userName, userName, "username");
        PasswordPage passwordPage = userNamePage.clickOnNextButton();

        passwordPage.sendKeys(passwordPage.password, password, "password");
        return passwordPage.clickOnNextButton();
    }
}
