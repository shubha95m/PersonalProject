package org.personal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.Page;

public class PasswordPage extends Page {

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = ".//button[@data-testid='loginSubmitButton']")
    public WebElement nextButton;

    public HomePage clickOnNextButton() {
        click(nextButton);
        return new HomePage(driver);
    }

    public void isLoaded() {
        waitForElement(password, 45);
    }
}
