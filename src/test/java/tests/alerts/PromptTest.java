package tests.alerts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class PromptTest {
    WebDriver driver = new EdgeDriver();

    @BeforeEach
    void setup() {
        driver.manage().window().maximize();
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.msedge.driver", "msedgedriver");
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new EdgeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
        driver.findElement(By.linkText("See a sample prompt")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message: " + alert.getText());
        alert.sendKeys("Selenium");
        Thread.sleep(2000);
        alert.accept();
        Assertions.assertTrue(true);
    }

    @Test
    void test2() throws InterruptedException {
        driver.get("https://www.google.com.br/");
        Thread.sleep(2000);
        Assertions.assertTrue(true);
    }
}
