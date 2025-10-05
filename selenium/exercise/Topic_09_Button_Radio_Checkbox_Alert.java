package exercise;

import keyword.commonKeywordExercise;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    if(BTN_DANGNHAP.isEnabled()){
        System.out.println("Dang nhap Button is Enabled");
    }else{
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
    public void TC_02_Default_Checkbox_Radio_Button(){
        // Select checkbox
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://demos.telerik.com/kendo-ui/checkbox/index");
        WebElement CHECKBOX_DEFAULT = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/parent::li//input"));
        if(!CHECKBOX_DEFAULT.isSelected()){
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
        if(!RADIO_DEFAULT.isSelected()){
            System.out.println("Radio is not selected");
            RADIO_DEFAULT.click();
        }
        Assert.assertTrue(RADIO_DEFAULT.isSelected());
    }

    @Test
    public void TC_03_Checkbox_Radio(){
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://material.angular.dev/components/radio/examples");
        By RADIO_SUMMER = By.xpath("//input[@value='Summer']");
        if(!driver.findElement(RADIO_SUMMER).isSelected()){
            System.out.println("Radio is not selected");
            driver.findElement(RADIO_SUMMER).click();
        }
        Assert.assertTrue(driver.findElement(RADIO_SUMMER).isSelected());

        commonKeywordExercise.GoToTheDynamicPage(driver, "https://material.angular.dev/components/checkbox/examples");
        By CHECKBOX_CHECKED = By.xpath("//label[text()='Checked']/..//input");
        if(!driver.findElement(CHECKBOX_CHECKED).isSelected()){
            System.out.println("Checkbox is not selected");
            driver.findElement(CHECKBOX_CHECKED).click();
        }
        Assert.assertTrue(driver.findElement(CHECKBOX_CHECKED).isSelected());

        if(driver.findElement(CHECKBOX_CHECKED).isSelected()){
            System.out.println("Checkbox is selected");
            driver.findElement(CHECKBOX_CHECKED).click();
        }
        Assert.assertFalse(driver.findElement(CHECKBOX_CHECKED).isSelected());

        By CHECKBOX_INDEMITERNATE = By.xpath("//label[text()='Indeterminate']/..//input");
        if(!driver.findElement(CHECKBOX_INDEMITERNATE).isSelected()){
            System.out.println("Checkbox is not selected");
            driver.findElement(CHECKBOX_INDEMITERNATE).click();
        }
        Assert.assertTrue(driver.findElement(CHECKBOX_INDEMITERNATE).isSelected());

        if(driver.findElement(CHECKBOX_INDEMITERNATE).isSelected()){
            System.out.println("Checkbox is selected");
            driver.findElement(CHECKBOX_INDEMITERNATE).click();
        }
        Assert.assertFalse(driver.findElement(CHECKBOX_INDEMITERNATE).isSelected());
    }

    @Test
    public void TC_04_Select_Multiple_Checkbox(){
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://automationfc.github.io/multiple-fields/");

        // Select all
        List<WebElement> CHECKBOX_MULTIPLE = driver.findElements(By.xpath("//input[@class='form-checkbox']"));
        for (WebElement checkbox : CHECKBOX_MULTIPLE) {
            if(!checkbox.isSelected()){
                System.out.println("Checkbox: "+ checkbox.getAttribute("value") +  " is not selected");
                checkbox.click(); // Select
            }
            Assert.assertTrue(checkbox.isSelected());
            checkbox.click(); // unSelect
            System.out.println("Checkbox: "+ checkbox.getAttribute("value") +  " is selected");
        }

        // Select Heart Attack
        driver.findElement(By.xpath("//input[@value='Heart Attack']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Heart Attack']")).isSelected());

    }

    @Test
    public void TC_05_Custom_Checkbox_Radio_Button(){
        commonKeywordExercise.GoToTheDynamicPage(driver, "https://login.ubuntu.com/");

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


}
