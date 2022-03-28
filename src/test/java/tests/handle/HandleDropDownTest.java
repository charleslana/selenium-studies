package tests.handle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class HandleDropDownTest {

    @Test
    void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownSelect = new Select(dropDown);
        dropdownSelect.selectByIndex(2);
        Thread.sleep(2000);
        dropdownSelect.selectByValue("1");
        Thread.sleep(2000);
        dropdownSelect.selectByVisibleText("Option 2");
        List<WebElement> listOptions = dropdownSelect.getOptions();
        listOptions.forEach(option -> System.out.println(option.getText()));
        Assertions.assertTrue(true);
    }
}
