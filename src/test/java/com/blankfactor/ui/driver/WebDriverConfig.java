package com.blankfactor.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class WebDriverConfig {

    public static void setupTest(WebDriver driver) {
        driver.get("https://hipertextual.com/");
        driver.manage().window().maximize();
    }

    public static WebDriver setupBrowser(WebDriver driver) {
        String browser = getParameterValue("driver");
        String arguments = getParameterValue("driverArguments");

        switch (browser) {
            case "chrome":
                if (!Objects.equals(arguments, "")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(arguments);
                    driver = new ChromeDriver(options);
                } else {
                    driver = new ChromeDriver();
                }
                break;
            case "firefox":
                driver = new FirefoxDriver();

                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
        }
        return driver;
    }

    private static String getParameterValue(String key) {
        return System.getProperty(key);
    }
}
