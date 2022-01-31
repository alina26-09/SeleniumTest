package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BookLoversPage;

import java.awt.print.Book;
import java.io.File;

public class DriverInit {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://keybooks.ro");
    }

    @AfterClass
    public void setDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure (ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot print = (TakesScreenshot) driver;
                File jpg = print.getScreenshotAs(OutputType.FILE);
                Files.copy(jpg, new File("Poze/" + result.getName() + ".jpg"));
            }
            catch (Exception e) {

            }
        }
    }
}
