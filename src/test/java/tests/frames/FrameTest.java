package tests.frames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class FrameTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("org.openqa.selenium")).click();
        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@title='All classes and interfaces (except non-static nested types)']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.linkText("WebDriver")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.findElement(By.linkText("HELP")).click();
        Assertions.assertTrue(true);
    }
}
