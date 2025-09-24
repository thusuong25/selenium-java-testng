package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    // Step 01: Setup env (OS / browser / web / page / data
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    // Step 02: Action / Excute: handle element / input / verify

    @AfterClass
    // Step 03: Clean: Delete Data test / browser / acc
    public void closeBrowser() {
        driver.quit();
    }
}
