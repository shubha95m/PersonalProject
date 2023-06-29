package org.personal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.Page;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[@data-testid='searchButton']")
    public WebElement searchButton;

    public boolean isSearchButtonDisplayed() {
        return isDisplayed(searchButton, "searchButton");
    }

    public void isLoaded() {
        waitForElement(searchButton, 45);
    }
}
