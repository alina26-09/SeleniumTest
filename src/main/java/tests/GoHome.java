package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderComponent;
import utils.DriverInit;

public class GoHome extends DriverInit {
    String cookBookStr = "Cooking with love";

    @Test
    public void goHomeTest () {
        HeaderComponent headerComponent = new HeaderComponent(driver);
        headerComponent.searchBook(cookBookStr);
        headerComponent.goHome();
        Assert.assertEquals(headerComponent.getTitle(), "Booklovers – Your Favorite Bookshelf!");
    }
}
