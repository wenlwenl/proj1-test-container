package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhpWebTest {
    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        //open the browser and url
        driver = new FirefoxDriver();
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
