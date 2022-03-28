package tests.navigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class NavigationCommandsTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        System.out.println("We are on home page: " + driver.getCurrentUrl());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa", Keys.RETURN);
        System.out.println("We are on search page: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("We are on home page again: " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("We are on search page again: " + driver.getCurrentUrl());
        driver.navigate().refresh();
        Assertions.assertTrue(true);
    }
}
