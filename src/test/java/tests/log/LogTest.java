package tests.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

class LogTest {

    @Test
        // log network
    void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://staging.iotickets.dev/");
        List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
        System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
        entries.forEach(enrty -> System.out.println(enrty.getMessage()));
        Assertions.assertTrue(true);
    }

    @Test
        // responses
    void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();
        //log file
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
            //req.getHeaders();
        });
        // Event will get fired
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            //System.out.println(res.getUrl());
            System.out.println(res.getStatus());
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();
        Assertions.assertTrue(true);
    }

    @Test
        // intercept
    void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty")) {
                String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockedUrl);
                devTools.send(Fetch.continueRequest(request.getRequestId(),
                        Optional.of(mockedUrl),
                        Optional.of(request.getRequest().getMethod()),
                        Optional.empty(),
                        Optional.empty()
                ));
                return;
            }
            devTools.send(Fetch.continueRequest(request.getRequestId(),
                    Optional.of(request.getRequest().getUrl()),
                    Optional.of(request.getRequest().getMethod()),
                    Optional.empty(),
                    Optional.empty()
            ));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        Assertions.assertTrue(true);
    }

    @Test
        // get response
    void test4() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.clearBrowserCache());
        devTools.send(Network.setCacheDisabled(true));
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.of(100000000)));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (responseReceived.getResponse().getUrl().contains("main-events")) {
                RequestId requestId = responseReceived.getRequestId();
                Integer status = responseReceived.getResponse().getStatus();
                String type = responseReceived.getType().toJson();
                String headers = responseReceived.getResponse().getHeaders().toString();
                String responseBody = devTools.send(Network.getResponseBody(requestId)).getBody();
                System.out.println(responseBody);
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    //List<HashMap<String, String>> list = objectMapper.readValue(responseBody, List.class);
                    List<MainEvents> list = objectMapper.readValue(responseBody, new TypeReference<List<MainEvents>>() {
                    });
                    System.out.println(list.get(0).name);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        });
        driver.get("https://staging.iotickets.dev/");
        Assertions.assertTrue(true);
    }

    @Test
        // example get response
    void test5() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.clearBrowserCache());
        devTools.send(Network.setCacheDisabled(true));
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (responseReceived.getResponse().getUrl().contains("filter?page=0")) {
                String responseBody = devTools.send(Network.getResponseBody(responseReceived.getRequestId())).getBody();
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    FilterEvents filterEvents = objectMapper.readValue(responseBody, FilterEvents.class);
                    System.out.println(filterEvents.numberOfElements);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        });
        driver.get("https://staging.iotickets.dev/eventos");
        Assertions.assertTrue(true);
    }
}
