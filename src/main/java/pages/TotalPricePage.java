package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

public class TotalPricePage extends SeleniumWrappers {

    @FindBy (xpath = "//td[@data-title='Total']")
    WebElement totalPrice;


    public TotalPricePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public double getTheTotalPrice() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return getDbPrice(totalPrice.getText());
    }
}
