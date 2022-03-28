package tests.get;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GetCommandsTest {

    @Test
        // get page source
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        String pageSource = driver.getPageSource();
        System.out.println("PageSource: " + pageSource);
        Assertions.assertTrue(true);
    }

    @Test
        // get title
    void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertTrue(true);
    }

    @Test
        // get current url
    void test3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.linkText("Downloads")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url: " + currentUrl);
        Assertions.assertTrue(true);
    }
}
