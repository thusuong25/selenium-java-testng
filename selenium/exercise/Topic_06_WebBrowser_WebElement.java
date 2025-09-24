package exercise;

import jdk.jfr.Description;
import locator.commonLocatorExercise;
import keyword.commonKeywordExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.TAB;

public class Topic_06_WebBrowser_WebElement {
    WebDriver driver;
    String BROWSER_BASE_URL = "https://live.techpanda.org/index.php/customer/account/";
    String Browser_URL_Login = BROWSER_BASE_URL + "login/";
    String Browser_URL_CreateAcc = BROWSER_BASE_URL + "create/";
    String MAILCHIMP_BASE_URL = "https://login.mailchimp.com/signup/";

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
    }

    @Description("Browser")
    @Test
    public void TC_01_Verify_Url() {
        commonKeywordExercise.GoToPageAndClickMyAccount(driver);
        Assert.assertEquals(driver.getCurrentUrl(), Browser_URL_Login);
        driver.findElement(By.xpath(commonLocatorExercise.BTN_CREATEANACCOUNT)).click();
        Assert.assertEquals(driver.getCurrentUrl(), Browser_URL_CreateAcc);
    }

    @Test
    public void TC_02_Verify_Title() {
        commonKeywordExercise.GoToPageAndClickMyAccount(driver);
        Assert.assertEquals(driver.getTitle(), "Customer Login");
        driver.findElement(By.xpath(commonLocatorExercise.BTN_CREATEANACCOUNT)).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_Function() {
        commonKeywordExercise.GoToPageAndClickMyAccount(driver);
        driver.findElement(By.xpath(commonLocatorExercise.BTN_CREATEANACCOUNT)).click();
        Assert.assertEquals(driver.getCurrentUrl(), Browser_URL_CreateAcc);
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), Browser_URL_Login);
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void TC_04_Get_Page_Source_Code() {
        commonKeywordExercise.GoToPageAndClickMyAccount(driver);
        String getTilePageLogin1 = driver.findElement(By.xpath(commonLocatorExercise.LOGIN_TITLE_LOGINPAGE)).getAttribute("innerHTML");
        String getTilePageLogin = driver.findElement(By.xpath(commonLocatorExercise.LOGIN_TITLE_LOGINPAGE)).getText();
        Assert.assertEquals(getTilePageLogin, "LOGIN OR CREATE AN ACCOUNT");
        Assert.assertEquals(getTilePageLogin1.strip(), "Login or Create an Account");
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.xpath(commonLocatorExercise.BTN_CREATEANACCOUNT)).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @Description("Element")
    @Test
    public void TC_01_Verify_Is_Displayed() {
        commonKeywordExercise.GoToThePageAndVerifyTheElement(driver);

        WebElement emailTextbox = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_INPUT_USEREMAIL));
        if (emailTextbox.isDisplayed()) {
            System.out.println("Email textbox is displayed");
            emailTextbox.sendKeys("Suong Thu");
        } else {
            System.out.println("Element is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_RADIO_UNDER18));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("Radio is displayed");
            ageUnder18Radio.click();
        } else {
            System.out.println("Radio is not displayed");
        }

        WebElement educationTextarea = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_TEXTAREA_EDUCATION));
        if (educationTextarea.isDisplayed()) {
            System.out.println("Education Textarea is displayed");
            educationTextarea.sendKeys("I am a princess");
        } else {
            System.out.println("Education Textarea is not displayed");
        }
        WebElement user5TextLabel = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_LABEL_USERTEXT));
        if (user5TextLabel.isDisplayed()) {
            System.out.println("User 5 Text Label is displayed");
        } else {
            System.out.println("User 5 Text Label is not displayed");
        }
    }

    @Test
    public void TC_02_Verify_Is_Enabled() {
        commonKeywordExercise.GoToThePageAndVerifyTheElement(driver);

        WebElement emailTextbox = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_INPUT_USEREMAIL));
        if (emailTextbox.isEnabled()) {
            System.out.println("Email textbox is enabled");
            emailTextbox.sendKeys("Suong Thu");
        } else {
            System.out.println("Email textbox is disable");
        }

        WebElement ageUnder18Radio = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_RADIO_UNDER18));
        if (ageUnder18Radio.isEnabled()) {
            System.out.println("Radio is enabled");
            ageUnder18Radio.click();
        } else {
            System.out.println("Radio is disable");
        }

        WebElement educationTextarea = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_TEXTAREA_EDUCATION));
        if (educationTextarea.isEnabled()) {
            System.out.println("Education Textarea is enabled");
            educationTextarea.sendKeys("I am a princess");
        } else {
            System.out.println("Education Textarea is disable");
        }

        WebElement passwordTextbox = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_INPUT_PASSWORD));
        if (passwordTextbox.isEnabled()) {
            System.out.println("Password textbox is enabled");
        } else {
            System.out.println("Password textbox is disable");
        }

        WebElement bioTextarea = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_TEXTAREA_BIIOGRAPHY));
        if (bioTextarea.isEnabled()) {
            System.out.println("Bio Textarea is enabled");
        } else {
            System.out.println("Bio Textarea is disable");
        }
    }

    @Test
    public void TC_03_Verify_Is_Selected() throws InterruptedException {
        // radio - checkbox - dropdown
        commonKeywordExercise.GoToThePageAndVerifyTheElement(driver);

        WebElement ageUnder18Radio = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_RADIO_UNDER18));
        if (ageUnder18Radio.isSelected()) {
            System.out.println("Age Under 18 Radio is selected");
        } else {
            System.out.println("Age Under 18 Radio is de-selected");
        }

        WebElement devCheckbox = driver.findElement(By.xpath(commonLocatorExercise.ELEMENT_CHECKBOX_DEV));
        if (devCheckbox.isSelected()) {
            System.out.println("Dev Checkbox is selected");
        } else {
            System.out.println("Dev Checkbox is de-selected");
        }

        ageUnder18Radio.click();
        devCheckbox.click();

        if (ageUnder18Radio.isSelected()) {
            System.out.println("Age Under 18 Radio is selected");
        } else {
            System.out.println("Age Under 18 Radio is de-selected");
        }

        if (devCheckbox.isSelected()) {
            System.out.println("Dev Checkbox is selected");
        } else {
            System.out.println("Dev Checkbox is de-selected");
        }
    }

    @Test
    public void TC_04_MailChimp_Register_Validate() {
        commonKeywordExercise.GoToTheMailChimpPage(driver);
        WebElement inputPassword = driver.findElement(By.xpath(commonLocatorExercise.MAILCHIMP_INPUT_PASSWORD));
        driver.findElement(By.xpath(commonLocatorExercise.MAILCHIMP_INPUT_MAIL)).sendKeys("ntt.suong@gmail.com");
        driver.findElement(By.xpath(commonLocatorExercise.MAILCHIMP_INPUT_MAIL)).sendKeys(Keys.ENTER);

        // Verify the input number into password
        inputPassword.sendKeys("12345");
        inputPassword.sendKeys(TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.plus-50 error completed")).isDisplayed());

        // Verify the input text into password
        inputPassword.clear();
        inputPassword.sendKeys("nttsuong");
        inputPassword.sendKeys(TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char not-completed")).isDisplayed());

        // valid data
        inputPassword.clear();
        inputPassword.sendKeys("Conchim25@");
        inputPassword.sendKeys(TAB);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char not-completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char not-completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char not-completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.plus-50 error completed")).isDisplayed());

    }


    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
