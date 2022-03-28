package tests.alerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {

    @Test
    void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
        driver.findElement(By.linkText("See an example alert")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert: message:" + alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Assertions.assertTrue(true);
    }
}
