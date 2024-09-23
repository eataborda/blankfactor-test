package com.blankfactor.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;

    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> getFluentWait() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(20));
        fluentWait.pollingEvery(Duration.ofMillis(1000));
        fluentWait.ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public void waitUntilElementIsVisible(WebElement webElement) {
        getFluentWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public void sendKeys(WebElement webElement, String text) {
        getFluentWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
        String message = "Send '" + text + "' to " + webElement.getAttribute("placeholder");
        logger.info(message);
    }

    public void click(WebElement webElement) {
        getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement));
        String message = "Click on " + webElement.getAttribute("id");
        logger.info(message);
        webElement.click();
    }

    public void scrollPageEnd() {
        new Actions(driver)
                .sendKeys(Keys.END).perform();
    }

    public void scrollToSpecificPagePoint(){
        new Actions(driver)
                .sendKeys(Keys.PAGE_DOWN)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.PAGE_DOWN)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.PAGE_DOWN)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.PAGE_DOWN)
                .pause(Duration.ofSeconds(2))
                .perform();
    }

    public void moveToElement(WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
