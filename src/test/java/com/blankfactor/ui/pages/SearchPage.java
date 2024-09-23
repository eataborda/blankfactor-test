package com.blankfactor.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectFirstArticleWithKeywords(String keywords) {
        WebElement element = getFirstArticleWithKeywords(keywords);
        click(element);
    }

    private WebElement getFirstArticleWithKeywords(String keywords) {
        List<WebElement> articleList = driver.findElements(By.xpath("//h2[@class='entry-title']"));
        WebElement article = null;
        for (WebElement element : articleList) {
            if (element.getText().contains(keywords)) {
                article = element;
            }
        }
        return article;
    }
}
