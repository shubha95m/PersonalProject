package org.personal;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Page extends LoadableComponent<Page> {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element, long seconds, String... elementName) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element, String... elementName) {
        waitForElement(element, 15);
        Allure.step("Clicking on " + Arrays.toString(elementName) + " element.");
        element.click();
    }

    public void sendKeys(WebElement element, String value, String... elementName) {
        Allure.step("Entering " + value + " in the " + Arrays.toString(elementName) + " element.");
        waitForElement(element, 15);
        element.sendKeys(value);
    }

    public String getText(WebElement element, String... elementName) {
        waitForElement(element, 15);
        Allure.step("Getting text from " + Arrays.toString(elementName));
        return element.getText();
    }

    public boolean isDisplayed(WebElement element, String... elementName) {
        waitForElement(element, 15);
        Allure.step("Verifying " + Arrays.toString(elementName) + " is Displayed?");
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element, String... elementName) {
        Allure.step("Verifying " + Arrays.toString(elementName) + " is Enabled?");
        return element.isEnabled();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
