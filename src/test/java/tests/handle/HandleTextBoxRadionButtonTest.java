package tests.handle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class HandleTextBoxRadionButtonTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("Is textBox Displayed: " + textBox.isDisplayed());
        System.out.println("Is textBox Enabled: " + textBox.isEnabled());
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Enable']"));
        System.out.println("Is button Displayed: " + button.isDisplayed());
        System.out.println("Is button Enabled: " + button.isEnabled());
        button.click();
        System.out.println("Is button Enabled after click: " + button.isEnabled());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//p[@id='message']")), "It's enabled!"));
        System.out.println("Is textBox Enabled after button click: " + textBox.isEnabled());
        textBox.sendKeys("test");
        Assertions.assertTrue(true);
    }
}
