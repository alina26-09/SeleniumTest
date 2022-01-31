package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

public class BookPage extends SeleniumWrappers {

    @FindBy(xpath="//button[@name='add-to-cart']") WebElement addToCart;
    @FindBy(xpath = "//span/bdi")  WebElement priceElem;


    public BookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void addBookToCart() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        click(addToCart);
    }

    public Double getThePrice() {
        wait.until(ExpectedConditions.visibilityOf(priceElem));
        String priceString = priceElem.getText();
        return getDbPrice(priceString);
    }
}
