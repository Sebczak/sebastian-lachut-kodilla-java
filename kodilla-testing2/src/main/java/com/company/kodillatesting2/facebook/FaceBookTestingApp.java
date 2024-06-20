package com.company.kodillatesting2.facebook;

import com.company.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FaceBookTestingApp {

    public final static String COOKIE_ELEMENT = "/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]";
    public final static String FIRST_NAME_ELEMENT = "//div[contains(@class, \"_5dbb _5634\")]/div/input";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(COOKIE_ELEMENT)).isDisplayed()) ;
        WebElement element = driver.findElement(By.xpath(COOKIE_ELEMENT));
        element.click();
        WebElement createNewAccountElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        createNewAccountElement.click();

        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));
        WebElement email = driver.findElement(By.name("reg_email__"));
        WebElement emailConfirm = driver.findElement(By.name("reg_email_confirmation__"));
        WebElement password = driver.findElement(By.name("reg_passwd__"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys("johndoe@example.com");
        emailConfirm.sendKeys("johndoe@example.com");
        password.sendKeys("SecurePassword123");

        Select daySelect = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id='year']")));

        daySelect.selectByValue("15");
        monthSelect.selectByValue("6");
        yearSelect.selectByValue("1990");

        WebElement genderMale = driver.findElement(By.xpath("//input[@value='2']"));
        genderMale.click();

        WebElement submitButton = driver.findElement(By.name("websubmit"));
        submitButton.click();
    }
}
