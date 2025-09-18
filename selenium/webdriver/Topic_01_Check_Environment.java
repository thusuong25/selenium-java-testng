package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }
}