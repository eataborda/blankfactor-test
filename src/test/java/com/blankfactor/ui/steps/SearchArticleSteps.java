package com.blankfactor.ui.steps;

import com.blankfactor.ui.pages.SearchPage;
import io.qameta.allure.Step;

public class SearchArticleSteps {
    private SearchPage searchPage;

    public SearchArticleSteps(SearchPage searchPage){
        this.searchPage = searchPage;

    }
    @Step("Select first article with keywords: {0}")
    public void selectFirstArticleWithKeywords(String keywords) {
        searchPage.selectFirstArticleWithKeywords(keywords);
    }
}
