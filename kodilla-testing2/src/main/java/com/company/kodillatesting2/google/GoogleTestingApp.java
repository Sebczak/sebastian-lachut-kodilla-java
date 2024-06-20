package com.company.kodillatesting2.google;

import com.company.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
