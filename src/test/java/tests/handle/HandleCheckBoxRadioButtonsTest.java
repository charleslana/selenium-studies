package tests.handle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HandleCheckBoxRadioButtonsTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        System.out.println("Is checkBox1 Displayed: " + checkBox1.isDisplayed());
        System.out.println("Is checkBox1 Enabled: " + checkBox1.isEnabled());
        System.out.println("Is checkBox1 Selected: " + checkBox1.isSelected());
        checkBox1.click();
        System.out.println("Is checkBox1 Selected after click: " + checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));
        System.out.println("Is checkBox2 Displayed: " + checkBox2.isDisplayed());
        System.out.println("Is checkBox2 Enabled: " + checkBox2.isEnabled());
        System.out.println("Is checkBox2 Selected: " + checkBox2.isSelected());
        checkBox2.click();
        System.out.println("Is checkBox2 Selected after click: " + checkBox2.isSelected());
        driver.navigate().to("https://demo.guru99.com/test/radio.html");
        WebElement option2 = driver.findElement(By.xpath("//input[@value='Option 2']"));
        System.out.println("Is option2 Displayed: " + option2.isDisplayed());
        System.out.println("Is option2 Enabled: " + option2.isEnabled());
        System.out.println("Is option2 Selected: " + option2.isSelected());
        option2.click();
        System.out.println("Is option2 Selected after click: " + option2.isSelected());
        Assertions.assertTrue(true);
    }
}
