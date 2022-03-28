package tests.wait;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

class FluentWaitTest {

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
        System.out.println(getExpectedDate());
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(selectedDate).getText().equals(getExpectedDate());
            }
        });
        WebElement selectedDateAfter = driver.findElement(selectedDate);
        System.out.println("After Select Date: " + selectedDateAfter.getText().trim());
        Assertions.assertTrue(true);
    }

    private String getExpectedDate() {
        LocalDate currentDate = LocalDate.now();
        Month month = currentDate.getMonth();
        Integer year = currentDate.getYear();
        DayOfWeek dayOfWeek = LocalDate.of(year, month, 5).getDayOfWeek();
        return StringUtils.capitalize(dayOfWeek.toString().toLowerCase()) + ", " + StringUtils.capitalize(month.toString().toLowerCase()) + " 5, " + year;
    }
}
