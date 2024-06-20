package com.company.kodillatesting2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverConfig {

    public final static String CHROME = "CHROME_DRIVER";
    public final static String FIREFOX = "FIREFOX_DRIVER";

    public static WebDriver getDriver(final String driver) {

        System.setProperty("webdriver.chrome.driver", "/home/sebczak/Documents/Development/Projects/Kodilla/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/sebczak/Documents/Development/Projects/Kodilla/geckodriver");


        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else if (driver.equals(FIREFOX)) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("/usr/bin/firefox");
            return new FirefoxDriver();
        } else {
            return null;
        }
    }
}
