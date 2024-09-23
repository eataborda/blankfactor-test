package com.blankfactor.ui.steps;

import com.blankfactor.ui.pages.SearchPage;

public class SearchArticleSteps {
    private SearchPage searchPage;

    public SearchArticleSteps(SearchPage searchPage){
        this.searchPage = searchPage;

    }

    public void selectFirstArticleWithKeywords(String keywords) {
        searchPage.selectFirstArticleWithKeywords(keywords);
    }
}
