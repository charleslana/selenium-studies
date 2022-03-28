package tests.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/#get-window-handle");
        String parent = driver.getWindowHandle();
        System.out.println("Parent Window: " + parent);
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("new window")).click();
        Set<String> stringSet = driver.getWindowHandles();
        stringSet.forEach(childWindow -> {
            if (!parent.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println("Child Window: " + driver.getWindowHandle());
                System.out.println("Title: " + driver.getTitle());
            }
        });
        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("New Tab: " + driver.getWindowHandle());
    }
}
