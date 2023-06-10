package org.personal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.personal.Page;

public class UserNamePage extends Page {

    public UserNamePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(id = "next-step")
    public WebElement nextButton;

    public PasswordPage clickOnNextButton() {
        click(nextButton);
        return new PasswordPage(driver);
    }

    public void isLoaded() {
        waitForElement(userName, 45);
    }
}
