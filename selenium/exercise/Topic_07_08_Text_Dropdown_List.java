package exercise;

import jdk.jfr.Description;
import locator.commonLocatorExercise;
import keyword.commonKeywordExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_07_08_Text_Dropdown_List {

    WebDriver driver;
    Select select;
    JavascriptExecutor jsExecutor;
    ChromeOptions options = new ChromeOptions();
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;


    // TC_01
    Random random = new Random();
    String randomNumber = String.valueOf(random.nextInt(99999));
    String email1 = "automation" + randomNumber + "@gmail.com";
    String password = "Abc@123456";
    String firstName = "Au" + System.currentTimeMillis();
    String lastName = "Test";

    // TC_02
    String usernameTC02 = "Admin";
    String passwordTC02 = "admin123";

    @BeforeClass
    public void InitialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        fluentWait = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_01_Register_Account_Textbox() throws InterruptedException {
        commonKeywordExercise.GoToPageAndClickMyAccount(driver);
        driver.findElement(By.xpath(commonLocatorExercise.BTN_CREATEANACCOUNT)).click();

        // register acc
        driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@title='Last Name']")).sendKeys(lastName);
        String email = firstName + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@title='Confirm Password']")).sendKeys(password);
        driver.findElement(By.xpath("//span[text()='Register']")).click();

        // Verify msg
        //commonKeywordExercise.clickIfExists(driver, By.xpath("//button[@id='proceed-button']"));
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),
                "Thank you for registering with Main Website Store." );
        String MsgRerult = driver.findElement(By.xpath("//div[@class='col-1']//p")).getText();
        System.out.println("Msg rerult = " + MsgRerult);
        Assert.assertTrue(MsgRerult.contains("Automation Test") && MsgRerult.contains(email));

        // Rating Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy' and @class='product-image']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();
        String review = "Tao khong thich \n Review \n thanh mot hang do";
        driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys(review);
        driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("okieconbe");
        driver.findElement(By.xpath("//input[@id='nickname_field']")).clear();
        driver.findElement(By.xpath("//input[@id='nickname_field']")).sendKeys("roiduocroi");
        driver.findElement(By.xpath("//span[text()='Submit Review']")).click();
        //commonKeywordExercise.clickIfExists(driver, By.xpath("//button[@id='proceed-button']"));
        Thread.sleep(5000);

        // Verify msg
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),
                "Your review has been accepted for moderation." );
    }

    @Test
    public void TC_02_Orange_HRM_Textbox() throws InterruptedException {
        // Go to the detail register page
        commonKeywordExercise.GoToTheOrangeHRMPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(usernameTC02);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordTC02);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

        // Input data
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//label[@class='oxd-label']/../..//input[@class='oxd-input oxd-input--active']")).clear();
        driver.findElement(By.xpath("//label[@class='oxd-label']/../..//input[@class='oxd-input oxd-input--active']")).sendKeys("2508");
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/../..//input")).sendKeys(firstName);
        driver.findElement(By.xpath("//label[text()='Password']/../..//input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/../..//input")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify data
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[@class='oxd-label']/../..//input[@class='oxd-input oxd-input--active']")).getAttribute("value"),"2508");

        // Select the Immigration tab & input data
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        driver.findElement(By.xpath("//h6[contains(.,'Assigned')]/..//button[contains(string(),'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/../..//input")).sendKeys("0336412345");
        driver.findElement(By.xpath("//label[text()='Comments']/../..//textarea")).sendKeys("0336412345\nla so cua\ntoi");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        WebElement pencilFill = driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pencilFill);
        pencilFill.click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='number']")).getAttribute("value"), "0336412345");
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='comments']")).getAttribute("value"), "0336412345\nla so cua\ntoi");

        // Log out
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        // log in new acc
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Menu My Info & verify data
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[@class='oxd-label']/../..//input[@class='oxd-input oxd-input--active']")).getAttribute("value"),"2508");
    }

    @Test
    public void TC_03_Nop_Commerce_Dropdown_List() throws InterruptedException {
        commonKeywordExercise.GoToTheNopCommercePage(driver);

        // Register acc
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@value='F']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email1);
        WebElement BTN_REGISTER = driver.findElement(By.xpath("//button[@id='register-button']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BTN_REGISTER);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        BTN_REGISTER.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");

        // Verify acc
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@value='F']")).getDomProperty("defaultChecked"), "true");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"), email1);

    }

    @Test
    public void TC_04_Rode_Dropdown_List() throws InterruptedException {
        commonKeywordExercise.GoToTheRodePage(driver);
        WebElement BTN_OPENMAP = driver.findElement(By.xpath("//a[text()='Where to Buy' and @class='link']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BTN_OPENMAP);
        BTN_OPENMAP.click();

        // Check the dropdown cannot multiple select
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDropdown = new Select(dropdownElement);
        if (countryDropdown.isMultiple()) {
            System.out.println("Dropdown can multiple select");
        } else {
            System.out.println("Dropdown can not multiple select");
        }

        // Select country
        new Select(driver.findElement(By.xpath("//select[@id='country']"))).selectByVisibleText("Vietnam");
        driver.findElement(By.xpath("//input[@id='map_search_query']")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        // Verify Dealer
        List<WebElement> dealerElement = driver.findElements(By.xpath("//h3[text()='Dealers']/parent::div//h4"));
        Assert.assertEquals(dealerElement.size(), 16);
        for (WebElement element : dealerElement) {
            System.out.println("Dealer text = " + element.getText());
        }

    }

    @Description("Custom Dropdown")
    @Test
    public void TC_05_Jquery_Custom_Dropdown() throws InterruptedException {
        commonKeywordExercise.GoToTheJqueryPage(driver);

        // select the option Medium
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='speed-button']")));
        driver.findElement(By.xpath("//span[@id='speed-button']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//div[@role='option']")));
        driver.findElement(By.xpath("//div[text()='Medium']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Medium");

        // select the option Fast
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='speed-button']")));
        driver.findElement(By.xpath("//span[@id='speed-button']")).click();
        List<WebElement> DROPDOWN_FAST = driver.findElements(By.xpath("//span[@id='speed-button']"));
        for (WebElement fast : DROPDOWN_FAST) {
            if (fast.getText().equals("Fast")) {
                fast.click();
                break;
            }
        }
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Fast");
    }

    @Test
    public void TC_05_React_Custom_Dropdown() throws InterruptedException {
        commonKeywordExercise.GoToTheReactPage(driver);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='dropdown icon']")));
        driver.findElement(By.xpath("//i[@class='dropdown icon']")).click();
        List<WebElement> option = driver.findElements(By.xpath("//div[@role='option']//span"));
        for (WebElement i : option) {
            System.out.println("Text = " + i.getText());
            if (i.getText().equals("Christian")) {
                i.click();
                break;
            }
        }
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Christian");
    }

    @AfterClass
    public void CloseBrowser(){
        driver.quit();
    }
}
