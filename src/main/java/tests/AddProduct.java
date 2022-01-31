package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverInit;

public class AddProduct extends DriverInit {
    String cookBookStr = "Cooking with love";
    String healthBookStr = "Let the sun shine";
    String cookBookXpath = "//div[@data-title='Cooking with love']";
    String healthBookXpath = "//div[@data-title='Let the sun shine']";

    @Test
    public void AddProductBookLovers() {
        BookLoversPage page = new BookLoversPage(driver);
        HeaderComponent header = new HeaderComponent(driver);
        SearchPage searchPage = new SearchPage(driver);
        BookPage bookPage = new BookPage(driver);
        TotalPricePage totalPricePage = new TotalPricePage(driver);

        double totalPrice = 0.00;
        // add the first book
        header.searchBook(cookBookStr);
        searchPage.clickOnTheBook(cookBookXpath);
        bookPage.addBookToCart();
        totalPrice += bookPage.getThePrice();

        // add the second book
        header.searchBook(healthBookStr);
        searchPage.clickOnTheBook(healthBookXpath);
        bookPage.addBookToCart();
        totalPrice += bookPage.getThePrice();

        System.out.println(totalPrice);

        // go to Cart
        header.viewCart();

        // verify  the total price
        double result = totalPricePage.getTheTotalPrice();
        Assert.assertEquals(result, totalPrice);
    }
}
