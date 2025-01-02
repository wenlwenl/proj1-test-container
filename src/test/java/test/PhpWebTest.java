package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhpWebTest {
    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Required for non-root users
        options.addArguments("--disable-dev-shm-usage"); // Prevents /dev/shm issues
        options.addArguments("--disable-gpu"); // Optional, useful for CI environments
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--window-size=1920,1080");
        
        //open the browser and url
        driver = new ChromeDriver();
        driver.get("http://192.168.1.220:8011");
    }
    
    @AfterTest
    public void afterTest() {
        //close the browser
        driver.quit();
    }
    
    @Test
    public void pageTitleValidation() {
        //from Harry && from Kane
        String expectedResult = "Apache2 Ubuntu Default Page: It works";
        String actualResult = driver.getTitle();
        
        Reporter.log("Expected Result = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);
        
        assertTrue(actualResult.equals(expectedResult), "mismatch in the page title");
    }
    
}
