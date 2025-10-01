package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_07_08_Text_Dropdown_List {

    WebDriver   driver;
    Select  select;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        String testing[] = {"Manual", "Mobile", "Security", "Perfomance"};

        Select select = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
        Assert.assertTrue(select.isMultiple());

        for (String value : testing) {
            select.selectByVisibleText(value);
            Thread.sleep(500);
        }

        List<WebElement> selectedOption = select.getAllSelectedOptions();
        Assert.assertEquals(selectedOption.size(), 4);

        List<String> actualValues = new ArrayList<String>();

        for (WebElement option : selectedOption) {
            actualValues.add(option.getText());
        }

        List<String> expectedValues = Arrays.asList(testing);

        Assert.assertEquals(actualValues, expectedValues);
    }

    public void selectMultiItemInDropdown(String parentXpath, String childXpath, String[] expectedValueItem) {
        // 1: click vào cái dropdown cho nó xổ hết tất cả các giá trị ra
        driver.findElement(By.xpath(parentXpath)).click();

        // 2: chờ cho tất cả các giá trị trong dropdown được load ra thành công
//        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(childXpath));

        // Duyệt qa hết tất cả các phần tử cho đến khi thỏa mãn điều kiện
        for (WebElement childElement : allItems) {
            // "January", "April", "July"
            for (String item : expectedValueItem) {
                if (childElement.getText().equals(item)) {
                    // 3: scroll đến item cần chọn (nếu như item cần chọn có thể nhìn thấy thì ko cần scroll)
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);

                    // 4: click vào item cần chọn
                    childElement.click();
//                    sleepInSecond(1);

                    List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
                    System.out.println("Item selected = " + itemSelected.size());
                    if (expectedValueItem.length == itemSelected.size()) {
                        break;
                    }
                }
            }
        }
    }


    @Test
    public boolean isItemSelected(String[] months) {
        List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
        int numberItemSelected = itemSelected.size();

        String allItemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice']/span)[1]")).getText();
        System.out.println("Text da chon = " + allItemSelectedText);

        if (numberItemSelected <= 3 && numberItemSelected > 0) {
            boolean status = true;
            for (String item : months) {
                if (!allItemSelectedText.contains(item)) {
                    status = false;
                    return status;
                }
            }
            return status;
        } else if (numberItemSelected >= 12) {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='All selected']")).isDisplayed();
        } else if (numberItemSelected > 3 && numberItemSelected < 12) {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='" + numberItemSelected + " of 12 selected']")).isDisplayed();
        } else {
            return false;
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
