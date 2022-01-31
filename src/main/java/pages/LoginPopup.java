package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

public class LoginPopup extends SeleniumWrappers {

    @FindBy(name = "log")
    WebElement userName;
    @FindBy(name="pwd") WebElement passwordElement;
    @FindBy(className = "submit_button") WebElement submitButton;
    @FindBy(xpath = "//div[@class='result sc_infobox sc_infobox_style_success']") WebElement loginSuccess;

    public LoginPopup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String userString, String password) {
        sendKeys(userName, userString);
        sendKeys(passwordElement, password);
        click(submitButton);
    }

    public boolean verifyPopupSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            // identify element
            // Explicit wait condition for visibility of element
            wait.until(ExpectedConditions.visibilityOf(loginSuccess));
            System.out.println("Element is visible");
            return true;
        }
        // if is timeout it means that the green success popup didn't show
        catch(TimeoutException n) {
            return false;
        }
    }

}
