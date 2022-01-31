package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

public class HeaderComponent extends SeleniumWrappers {

    @FindBy(xpath = "//form[@role='search']")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@class='search_field']")
    WebElement searchBar;

    @FindBy(className = "menu_user_cart")
    WebElement cartIcon;

    @FindBy(xpath = "//p/a[@class='button wc-forward']")
    WebElement viewCartButton;

    @FindBy(xpath = "//div/div[@class='logo']")
    WebElement homePageIcon;

    @FindBy(className = "menu_user_login") public WebElement loginIcon;

    @FindBy(className = "logo") WebElement logoToHome;

    @FindBy(className = "menu_user_logout")
    public WebElement logoutIcon;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchBook(String book) {
        wait = new WebDriverWait(driver, 5);
        click(searchIcon);
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        sendKeys(searchBar, book);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void viewCart() {
        click(cartIcon);
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        click(viewCartButton);
    }

    public void goHome() {
        click(logoToHome);
    }

    public  String getTitle() {
        return driver.getTitle();
    }

}
