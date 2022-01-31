package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BookLoversPage extends SeleniumWrappers {
    // user: TestUser
    // pas: 12345@67890

    @FindBy(xpath = "//div/div[@class='logo']") WebElement homePageIcon;

    public BookLoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
   }
}
