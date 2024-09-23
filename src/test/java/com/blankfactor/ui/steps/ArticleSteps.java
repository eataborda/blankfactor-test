package com.blankfactor.ui.steps;

import com.blankfactor.ui.pages.ArticlePage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticleSteps {
    private ArticlePage articlePage;

    public ArticleSteps(ArticlePage articlePage){
        this.articlePage = articlePage;
    }
    @Step("Validate current article is the expected: {0}")
    public void validateCurrentArticleIsTheExpected(String keywords){
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(articlePage.getDriver().getCurrentUrl())
                .as("Validate if the current URL is the expected")
                .isEqualTo("https://hipertextual.com/2023/08/reed-jobs-hijo-steve-jobs-yosemite-nuevos-tratamientos-cancer");
        assertions.assertThat(articlePage.getArticleTitle().getText())
                .as("Validate if the current title contains the searched keyword")
                .contains(keywords);
        assertions.assertThat(articlePage.getArticleSubtitle().getText())
                .as("Validate if the current subtitle contains the searched keyword")
                .contains(keywords);
        List<WebElement> articleParagraphs = articlePage.getDriver().findElements(By.xpath("//div[@class='entry-content']//p"));
        assertions.assertThat(articleParagraphs.get(0).getText())
                .as("Validate if the first paragraph of the article contains the searched keyword")
                .contains(keywords);
        assertions.assertAll();
    }
    @Step("Subscribe to the newsletter")
    public void subscribeToTheNewsLetter(){
        articlePage.subscribeToTheNewsLetter();
    }
}
