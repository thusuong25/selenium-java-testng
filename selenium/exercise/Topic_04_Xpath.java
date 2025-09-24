package exercise;

import locator.commonLocatorExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Topic_04_Xpath {
    WebDriver driver;

    @Test
    public void TC_01_Find_Locator() {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(commonLocatorExercise.LOGIN_INPUT_HOVATEN)).sendKeys("Test");
        driver.quit();
    }
}

