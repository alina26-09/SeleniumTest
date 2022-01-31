package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HeaderComponent;
import pages.LoginPopup;
import utils.DriverInit;

import java.lang.reflect.Method;

public class LoginTest extends DriverInit {


    @NeedsSpecialSetup
    @Test
    public void loginTest() throws InterruptedException {
        HeaderComponent header = new HeaderComponent(driver);
        LoginPopup loginPp = new LoginPopup(driver);
        // click on login icon and try to send keys
        header.click(header.loginIcon);
        loginPp.login("TestUser", "12345@67890");
        // verify if the green success popup is visible
        Assert.assertEquals(true, loginPp.verifyPopupSuccess());
    }


    @AfterMethod
    public void resetPage(Method method) {
        NeedsSpecialSetup needsSpecialSetup = method.getAnnotation(NeedsSpecialSetup.class);
        if(needsSpecialSetup == null) {
            return;
        }
        HeaderComponent header = new HeaderComponent(driver);
        header.click(header.logoutIcon);
        System.out.println("HEREEEEEE");
    }

    @Test(priority = 1)
    public void loginFailTest() throws InterruptedException {
        HeaderComponent header = new HeaderComponent(driver);
        LoginPopup loginPp = new LoginPopup(driver);
        header.click(header.loginIcon);
        loginPp.login("TestUserrrrrfg", "12345@67890");
        Assert.assertEquals(false, loginPp.verifyPopupSuccess());
    }
}
