package com.blankfactor.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@id='search-toggle']")
    WebElement searchIcon;

    @FindBy(id = "search-form-2")
    WebElement searchForm;

    @FindBy(xpath="//input[@id='search-form-2']//following-sibling::button[@class='search-submit']")
    WebElement searchSubmit;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void accessHomePage(){
        driver = new ChromeDriver();
        driver.get("https://hipertextual.com/");
        driver.manage().window().maximize();
    }

    public void searchWithKeyWords(String keywords){
        click(searchIcon);
        sendKeys(searchForm,keywords);
        click(searchSubmit);
    }
}
