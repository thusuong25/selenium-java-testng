package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class commonKeywordExercise {
    public static void GoToPageAndClickMyAccount(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath(locator.commonLocatorExercise.BTN_MYACCOUNT)).click();
    }

    public static void GoToThePageAndVerifyTheElement(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/basic-form/index.html");
    }

    public static void GoToTheMailChimpPage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://login.mailchimp.com/signup/");
    }

}
