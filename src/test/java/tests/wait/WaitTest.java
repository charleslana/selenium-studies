package tests.wait;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class WaitTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        By selectedDate = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");
        WebElement selectedDateBefore = driver.findElement(selectedDate);
        System.out.println("Before Select Date: " + selectedDateBefore.getText().trim());
        driver.findElement(By.xpath("//a[normalize-space()='5']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));
        WebElement selectedDateAfter = driver.findElement(selectedDate);
        System.out.println("After Select Date: " + selectedDateAfter.getText().trim());
        Assertions.assertTrue(true);
    }
}
