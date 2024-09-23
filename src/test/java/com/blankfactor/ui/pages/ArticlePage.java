package com.blankfactor.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticlePage extends BasePage {

    @FindBy(xpath = "//h1[@class='entry-title entry-title--with-subtitle']")
    WebElement articleTitle;

    @FindBy(xpath = "//div[@class='newspack-post-subtitle']")
    WebElement articleSubtitle;

    @FindBy(xpath = "//input[@placeholder='example@gmail.com']")
    WebElement subscribeForm;
    @FindBy(xpath = "//form[@class='custom-substack-widget csw-theme-custom']//button[@type='submit']")
    WebElement subscribeButton;

    @FindBy(xpath = "//p[@class='success']")
    WebElement subscribeSuccessMessage;

    private final WebDriver driver;
    public ArticlePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getArticleTitle() {
        return articleTitle;
    }

    public WebElement getArticleSubtitle() {
        return articleSubtitle;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void subscribeToTheNewsLetter(){
        scrollToSpecificPagePoint();
        moveToElement(subscribeForm);
        sendKeys(subscribeForm,"eataborda@gmail.com");
        click(subscribeButton);
        waitUntilElementIsVisible(subscribeSuccessMessage);
    }
}
