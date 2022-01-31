package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends DriverInit {
    public WebDriverWait wait;
    public WebDriver driver;

    public SeleniumWrappers(WebDriver driver) {
        this.driver = driver;
    }


    public void click(WebElement selector) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        try {
            selector.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(WebElement selector, String value) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        try {
            selector.sendKeys(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getDbPrice(String stringPrice) {
        double price = 0.00;
        stringPrice = stringPrice.substring(1);
        price = Double.parseDouble(stringPrice);
        return price;
    }

}
