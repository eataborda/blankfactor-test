package com.blankfactor.ui.steps;

import com.blankfactor.ui.pages.HomePage;
import io.qameta.allure.Step;

public class HomeSteps {
    private HomePage homePage;

    public HomeSteps(HomePage homePage){
        this.homePage = homePage;
    }
    @Step("Search with keywords: {0}")
    public void searchWithKeyWords(String keywords){
        homePage.searchWithKeyWords(keywords);
    }
}
