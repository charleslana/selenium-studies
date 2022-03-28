package tests.locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class LocatorsTest {

    @Test
        // id, name, classname, tagname
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/users/login");
        WebElement email = driver.findElement(By.id("email"));
        System.out.println(email);
        email.sendKeys("teste");
        WebElement password = driver.findElement(By.name("password"));
        System.out.println(password);
        WebElement button = driver.findElement(By.className("s-btn__primary"));
        System.out.println(button);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total anchor tags: " + links.size());
        links.forEach(link -> System.out.println(link.getText()));
        Assertions.assertTrue(true);
    }

    @Test
        // tag and id
    void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/users/login");
        WebElement button = driver.findElement(By.cssSelector("button#submit-button"));
        System.out.println(button);
        Assertions.assertTrue(true);
    }

    @Test
        // tag and attribute
    void test3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/users/login");
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
        System.out.println(searchBox);
        searchBox.sendKeys("Selenium", Keys.ENTER);
        Assertions.assertTrue(true);
    }

    @Test
        // tag and class
    void test4() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        WebElement button = driver.findElement(By.cssSelector("a.login-link"));
        System.out.println(button);
        button.click();
        Assertions.assertTrue(true);
    }

    @Test
        // tag, class and attribute
    void test5() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        WebElement button = driver.findElement(By.cssSelector("a.-marketing-link.js-gps-track[href='https://stackoverflow.co/']"));
        System.out.println(button);
        button.click();
        Assertions.assertTrue(true);
    }

    @Test
        // linktest
    void test6() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        WebElement button = driver.findElement(By.linkText("For Teams"));
        System.out.println(button);
        button.click();
        Assertions.assertTrue(true);
    }

    @Test
        // partialLinkText
    void test7() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        WebElement button = driver.findElement(By.partialLinkText("large organizations"));
        System.out.println(button);
        button.click();
        Assertions.assertTrue(true);
    }

    @Test
        // xpath Full xpath/Absolute xpath
    void test8() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        WebElement searchBox = driver.findElement(By.xpath("/html/body/header/nav/div/div/span/input"));
        System.out.println(searchBox);
        searchBox.sendKeys("WebDriver");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        Assertions.assertTrue(true);
    }

    @Test
        // xpath Relative xpath
    void test9() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/div/span/input"));
        System.out.println(searchBox);
        searchBox.sendKeys("WebDriver");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        Assertions.assertTrue(true);
    }

    @Test
        // selectorshub Full xpath/Absolute xpath
    void test9a() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        WebElement searchBox = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/div[1]/span[1]/input[1]"));
        System.out.println(searchBox);
        searchBox.sendKeys("WebDriver");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        Assertions.assertTrue(true);
    }

    @Test
        // selectorshub Relative xpath
    void test9b() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='\uF002 Search this site…']"));
        System.out.println(searchBox);
        searchBox.sendKeys("WebDriver");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        Assertions.assertTrue(true);
    }
}
