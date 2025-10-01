package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_06_WebBrowser_WebElement_APIs {
    // Khai báo biến driver
    WebDriver driver;
    String firstname, lastname, address, city;
    int price, productSize;

    // Open browser &
    @BeforeTest
    public void initData() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Testcase để thực thi
    @Test
    public void TC_01_WebBrowserAPI() throws InterruptedException {
        // close browser if only tab or tab is focus
        // driver.close();

        // close all browser
        // driver.quit();

        // Open Url (App link)
        driver.get("https://www.facebook.com/");

        // Get url current page
        String homePageUrl = driver.getCurrentUrl();

        // Verify 1 condition is correct
        Assert.assertTrue(homePageUrl.equals("https://www.facebook.com/"));

        // Verify 1 condition is correct
        Assert.assertFalse(homePageUrl.equals("https://www.facebook.com/"));

        // Verify 1 input and output condition is equal
        Assert.assertEquals(homePageUrl, "https://www.facebook.com/");

        // assertTrue/False: Returns boolean type (true/ false) -> isDisplayed/
        // isEnabled/ isSelected/...
        // assertEquals: Returns data type: String/ int/ double/ float/...

        // Returns the source code of the current page (html/ css/ jquery/ js/..)
         String homePageSource = driver.getPageSource();
         Assert.assertTrue(homePageSource.contains("This is demo site for"));

        // Returns the title of the current page
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Home page");

        // Handle Windows/ Tabs
        driver.getWindowHandle();
        driver.getWindowHandles();

        // wait for an element to be found
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Wait for a page to load successfully
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // Test GUI: Graphic User Interface
        driver.manage().window().maximize();

         // driver.navigate().back/refresh/forwar();

        // Tracking lại history
//         driver.navigate().to("https://www.facebook.com/");

        // Alert/ Iframe (Frame)/ Windows
        driver.switchTo().alert().accept();
        driver.switchTo().frame("");
        driver.switchTo().window("");
    }

    // Testcase để thực thi
    @Test
    public void TC_02_WebElementAPI() {
        // Tìm 1 element or nhiều vs locator

        // Cách 1: Nếu như mà element này chỉ dùng 1 lần
        driver.findElement(By.id("search")).sendKeys("Samsung");

        // Cách 2: Nếu như mà element này thao tác nhiều lần -> Khai báo biến
        WebElement searchTextbox = driver.findElement(By.id("search"));

        // Xóa dữ liệu trước khi sendkey
        searchTextbox.clear();

        // Nhập dữ liệu vào 1 textbox/ textarea
        searchTextbox.sendKeys("");

        // Click vào 1 element: button/ link/ radio/ checkbox/..
        searchTextbox.click();

        // Tìm và thao tác vs 1 element: findElement
        searchTextbox.findElement(By.id("search")).click();

        // Tìm và thao tác vs nhiều element: findElements
        searchTextbox.findElements(By.id("search")).get(0).click();

        // 0 1 2 3 4 5 -> index
        // A B C X Y Z -> data

        // tagname[@attribute='value'] = //input[@id='search']
        String searchPlaceholderValue = searchTextbox.getAttribute("placeholder");

        // Test GUI: font/ size/ color/ position/ size/....
        String loginButtonColor = searchTextbox.getCssValue("background");
        // #3399cc

        // Build framework: Chụp hình nhúng vào Report
        // searchTextbox.getScreenshotAs(arg0)

        WebElement searchTextbox_ = driver.findElement(By.cssSelector("#search"));
        // String searchTextboxTagname = searchTextbox_.getTagName();
        // searchTextboxTagname = input

        // Text of link/ button/ label/...
        String searchText = searchTextbox.getText();

        // assertTrue/ False
        Assert.assertTrue(searchTextbox.isDisplayed());
        Assert.assertTrue(searchTextbox.isEnabled());

        // Radio/ Checkbox
        Assert.assertTrue(searchTextbox.isSelected());

        boolean searchTextboxStatus = searchTextbox.isSelected();
        Assert.assertFalse(searchTextboxStatus);
        Assert.assertEquals(searchTextboxStatus, false);

        searchTextbox.click();

        // Work vs form (login/ register) -> Tagname = form
        // searchTextbox.submit();
    }

    // Close browser/ clean data
    @AfterTest
    public void cleanData() {
        // Close browser
        driver.quit();
    }

}