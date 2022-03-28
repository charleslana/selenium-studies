package tests.tables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class TableTest {

    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        WebElement cols = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[4]/td[4]"));
        System.out.println(cols.getText());
        List<WebElement> allCols = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No. of cols: " + allCols.size());
        allCols.forEach(col -> System.out.print(col.getText().concat(" ")));
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        System.out.println();
        System.out.println("No. of rows: " + allRows.size());
        allRows.forEach(row -> System.out.println(row.getText()));
        Assertions.assertTrue(true);
    }
}
