package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    public static boolean clickIfExists(WebDriver driver, By locator) {
        var elements = driver.findElements(locator);
        if (!elements.isEmpty() && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
            elements.get(0).click();
            return true;
        }
        return false;
    }

    public static void GoToTheOrangeHRMPage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public static void GoToTheNopCommercePage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public static void GoToTheRodePage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://rode.com/en-int/support/where-to-buy");
    }

    public static void GoToTheJqueryPage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
    }

    public static void GoToTheReactPage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
    }



    public static void AllowInsecure(String[] args) {
        // Khai báo ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Khởi tạo WebDriver với options
        WebDriver driver = new ChromeDriver(options);

        // Bỏ qua certificate errors
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");

        // Treat http://live.techpanda.org như https
        options.addArguments("-l--allow-insecureocalhost --ignore-certificate-errors --disable-popup-blocking --unsafely-treat-insecure-origin-as-secure=http://live.techpanda.org");

        // Chặn popup/blocking
        options.addArguments("--disable-popup-blocking");

        // Truy cập vào trang
        driver.get("http://live.techpanda.org");

        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-features=InsecureFormSubmissionWarning"); // quan trọng
    }

}
