package exercise;

import keyword.commonKeywordExercise;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_09_Button_Radio_Checkbox_Alert {
    WebDriver driver;

    // button
    String user = "conchimnon958@gmail.com";
    String password = "Abc@123456";


    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Button() throws InterruptedException {
        commonKeywordExercise.GoToTheFahasaPage(driver);
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
        WebElement BTN_DANGNHAP = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));
        //By BTN_DANGNHAP1 = By.xpath("//button[@class='fhs-btn-login']");

        // Displayed
        if (BTN_DANGNHAP.isEnabled()) {
            System.out.println("Dang nhap Button is Enabled");
        } else {
            System.out.println("Dang nhap Button is not Enabled");
        }
        Assert.assertFalse(BTN_DANGNHAP.isEnabled());

        // Verify color
        String color = BTN_DANGNHAP.getCssValue("background-color");
        Color getColor = Color.fromString(color);
        System.out.println("Color of Dang nhap Button = " + getColor);
        Assert.assertEquals(getColor.asHex(), "#000000");

        // Input Data
        driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys(password);

        // Verify button
        Thread.sleep(500);
        Assert.assertTrue(BTN_DANGNHAP.isEnabled());
        String color1 = BTN_DANGNHAP.getCssValue("background-color");
        Color getColor1 = Color.fromString(color1);
        System.out.println("Color of Dang nhap Button = " + getColor1);
        Assert.assertEquals(getColor1.asHex(), "#c92127");
        //Assert.assertEquals(Color.fromString(driver.findElement(BTN_DANGNHAP1).getCssValue("background-color")).asHex().toUpperCase(), "#c92127");
    }

    @Test
    public void TC_02_Default_Checkbox_Radio_Button() {
        // Select checkbox
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://demos.telerik.com/kendo-ui/checkbox/index");
        WebElement CHECKBOX_DEFAULT = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/parent::li//input"));
        if (!CHECKBOX_DEFAULT.isSelected()) {
            System.out.println("Checkbox is not selected");
            CHECKBOX_DEFAULT.click();
        }
        if (CHECKBOX_DEFAULT.isSelected()) {
            System.out.println("Checkbox is selected");
            CHECKBOX_DEFAULT.click();
        }
        Assert.assertFalse(CHECKBOX_DEFAULT.isSelected());

        // Select radio
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://demos.telerik.com/kendo-ui/radiobutton/index");
        WebElement RADIO_DEFAULT = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span//input"));
        if (!RADIO_DEFAULT.isSelected()) {
            System.out.println("Radio is not selected");
            RADIO_DEFAULT.click();
        }
        Assert.assertTrue(RADIO_DEFAULT.isSelected());
    }

    @Test
    public void TC_03_Checkbox_Radio() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://material.angular.dev/components/radio/examples");
        By RADIO_SUMMER = By.xpath("//input[@value='Summer']");
        if (!driver.findElement(RADIO_SUMMER).isSelected()) {
            System.out.println("Radio is not selected");
            driver.findElement(RADIO_SUMMER).click();
        }
        Assert.assertTrue(driver.findElement(RADIO_SUMMER).isSelected());

        commonKeywordExercise.GoToTheDynamicPage(driver, "https://material.angular.dev/components/checkbox/examples");
        By CHECKBOX_CHECKED = By.xpath("//label[text()='Checked']/..//input");
        if (!driver.findElement(CHECKBOX_CHECKED).isSelected()) {
            System.out.println("Checkbox is not selected");
            driver.findElement(CHECKBOX_CHECKED).click();
        }
        Assert.assertTrue(driver.findElement(CHECKBOX_CHECKED).isSelected());

        if (driver.findElement(CHECKBOX_CHECKED).isSelected()) {
            System.out.println("Checkbox is selected");
            driver.findElement(CHECKBOX_CHECKED).click();
        }
        Assert.assertFalse(driver.findElement(CHECKBOX_CHECKED).isSelected());

        By CHECKBOX_INDEMITERNATE = By.xpath("//label[text()='Indeterminate']/..//input");
        if (!driver.findElement(CHECKBOX_INDEMITERNATE).isSelected()) {
            System.out.println("Checkbox is not selected");
            driver.findElement(CHECKBOX_INDEMITERNATE).click();
        }
        Assert.assertTrue(driver.findElement(CHECKBOX_INDEMITERNATE).isSelected());

        if (driver.findElement(CHECKBOX_INDEMITERNATE).isSelected()) {
            System.out.println("Checkbox is selected");
            driver.findElement(CHECKBOX_INDEMITERNATE).click();
        }
        Assert.assertFalse(driver.findElement(CHECKBOX_INDEMITERNATE).isSelected());
    }

    @Test
    public void TC_04_Select_Multiple_Checkbox() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://automationfc.github.io/multiple-fields/");

        // Select all
        List<WebElement> CHECKBOX_MULTIPLE = driver.findElements(By.xpath("//input[@class='form-checkbox']"));
        for (WebElement checkbox : CHECKBOX_MULTIPLE) {
            if (!checkbox.isSelected()) {
                System.out.println("Checkbox: " + checkbox.getAttribute("value") + " is not selected");
                checkbox.click(); // Select
            }
            Assert.assertTrue(checkbox.isSelected());
            checkbox.click(); // unSelect
            System.out.println("Checkbox: " + checkbox.getAttribute("value") + " is selected");
        }

        // Select Heart Attack
        driver.findElement(By.xpath("//input[@value='Heart Attack']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Heart Attack']")).isSelected());

    }

    @Test
    public void TC_05_Custom_Checkbox_Radio_Button() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://login.ubuntu.com/");
        //driver.findElement(By.xpath("//label[@for='id_new_user']")).click();
        By RADIO_CUSTOM = By.xpath("//input[@id='id_new_user']");
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", driver.findElement(RADIO_CUSTOM));
        Assert.assertTrue(driver.findElement(RADIO_CUSTOM).isSelected());

        By CHECKBOX_CUSTOM = By.xpath("//input[@id='id_accept_tos']");
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", driver.findElement(CHECKBOX_CUSTOM));
        Assert.assertTrue(driver.findElement(CHECKBOX_CUSTOM).isSelected());
    }

    @Test
    public void TC_06_Custom_Checkbox_Radio_Button() throws InterruptedException {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By RADIO_CANTHO = By.xpath("//div[@data-value='Cần Thơ']");

        // Verify get Attribute Checked
        Assert.assertTrue(driver.findElement(RADIO_CANTHO).getDomAttribute("aria-checked").contains("false"));
        driver.findElement(RADIO_CANTHO).click();
        Assert.assertTrue(driver.findElement(RADIO_CANTHO).getDomAttribute("aria-checked").contains("true"));

        // Verify isDisplayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Cần Thơ' and @aria-checked='true']")).isDisplayed());
    }

    @Test
    public void TC_07_Accept_Alert() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://automationfc.github.io/basic-form/index.html");
        By ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
        driver.findElement(ALERT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
//        alert.dismiss(); // cancel
//        alert.sendKeys("Hello"); // input
        String msg_alert = alert.getText(); // get text
        System.out.println("Message alert = " + msg_alert);
        Assert.assertEquals(msg_alert, "I am a JS Alert");
        alert.accept();
        WebElement msg_result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(msg_result.getText(), "You clicked an alert successfully");
    }

    @Test
    public void TC_08_Confirm_Alert() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://automationfc.github.io/basic-form/index.html");
        By ALERT1_BUTTON = By.xpath("//button[@onclick='jsConfirm()']");
        driver.findElement(ALERT1_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        String msg_alert = alert.getText(); // get text
        System.out.println("Message alert = " + msg_alert);
        Assert.assertEquals(msg_alert, "I am a JS Confirm");
        alert.dismiss();
        WebElement msg_result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(msg_result.getText(), "You clicked: Cancel");
    }

    @Test
    public void TC_09_Prompt_Alert() {
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://automationfc.github.io/basic-form/index.html");
        By ALERT2_BUTTON = By.xpath("//button[@onclick='jsPrompt()']");
        driver.findElement(ALERT2_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        String msg_alert = alert.getText(); // get text
        System.out.println("Message alert = " + msg_alert);
        Assert.assertEquals(msg_alert, "I am a JS prompt");
        alert.sendKeys("thusuong");
        alert.accept();
        WebElement msg_result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(msg_result.getText(), "You entered: thusuong");
    }

    @Test
    public void TC_11_Authentication_Alert(){
        String username = "admin";
        String password = "admin";
        String URL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        System.out.println("URL = " + URL);
        String msg_result = "Congratulations! You must have the proper credentials.";
        commonKeywordExercise.GoToTheDynamicPage(driver, URL);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']//p")).getText(), msg_result);
        // Trick : click button -> get URL -> login by alert
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


}
