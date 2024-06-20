package com.company.kodillatesting2.ebay;

import com.company.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.com/");


        WebElement searchField = driver.findElement(By.name("_nkw"));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
