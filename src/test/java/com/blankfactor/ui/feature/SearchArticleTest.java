package com.blankfactor.ui.feature;

import com.blankfactor.ui.driver.WebDriverConfig;
import com.blankfactor.ui.pages.ArticlePage;
import com.blankfactor.ui.pages.HomePage;
import com.blankfactor.ui.pages.SearchPage;
import com.blankfactor.ui.steps.ArticleSteps;
import com.blankfactor.ui.steps.HomeSteps;
import com.blankfactor.ui.steps.SearchArticleSteps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

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
    public void searchAnArticleAndSuscribe() {
        homeSteps.searchWithKeyWords("Steve Jobs");
        searchArticleSteps.selectFirstArticleWithKeywords("Reed Jobs");
        articleSteps.validateCurrentArticleIsTheExpected("Reed Jobs");
        articleSteps.subscribeToTheNewsLetter();
    }

}
