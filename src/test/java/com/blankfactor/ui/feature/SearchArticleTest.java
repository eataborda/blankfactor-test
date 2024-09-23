package com.blankfactor.ui.feature;

import com.blankfactor.ui.driver.WebDriverConfig;
import com.blankfactor.ui.pages.ArticlePage;
import com.blankfactor.ui.pages.HomePage;
import com.blankfactor.ui.pages.SearchPage;
import com.blankfactor.ui.steps.ArticleSteps;
import com.blankfactor.ui.steps.HomeSteps;
import com.blankfactor.ui.steps.SearchArticleSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
@DisplayName("Search article test")
@Epic("Search")
public class SearchArticleTest {
    private WebDriver driver;
    private HomeSteps homeSteps;
    private SearchArticleSteps searchArticleSteps;
    private ArticleSteps articleSteps;

    @BeforeEach
    public void setupTest() {
        driver = WebDriverConfig.setupBrowser(driver);
        WebDriverConfig.setupTest(driver);

        homeSteps = new HomeSteps(new HomePage(driver));
        searchArticleSteps = new SearchArticleSteps(new SearchPage(driver));
        articleSteps = new ArticleSteps(new ArticlePage(driver));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Search an Article and subscribe")
    @Description("Example of an article search into the hipertextual webpage")
    @Feature("Search articles")
    public void searchAnArticleAndSubscribe() {
        homeSteps.searchWithKeyWords("Steve Jobs");
        searchArticleSteps.selectFirstArticleWithKeywords("Reed Jobs");
        articleSteps.validateCurrentArticleIsTheExpected("Reed Jobs");
        articleSteps.subscribeToTheNewsLetter();
    }

}
