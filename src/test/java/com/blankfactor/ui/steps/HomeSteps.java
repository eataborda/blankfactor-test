package com.blankfactor.ui.steps;

import com.blankfactor.ui.pages.HomePage;

public class HomeSteps {
    private HomePage homePage;

    public HomeSteps(HomePage homePage){
        this.homePage = homePage;
    }

    public void searchWithKeyWords(String keywords){
        homePage.searchWithKeyWords(keywords);
    }
}
