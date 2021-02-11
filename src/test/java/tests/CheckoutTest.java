package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkTotalPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openProductPageByLink("Sauce Labs Bike Light");
        double priceProduct = Double.parseDouble(productsPage.productPriceProductPage());
        productsPage.addProductToCartProduct();
        cartPage.open();

        Assert.assertTrue(cartPage.cartPageIsOpened(), "Cart page is not opened!");

        cartPage.checkout();
        checkoutPage.addFirstName("alex");
        checkoutPage.addLastName("fifa");
        checkoutPage.addPostal("220000");
        checkoutPage.clickContinueToGoToOverview();
        String result = String.format("%.2f", priceProduct + checkoutPage.getTaxes());
        String totalPriceFromPage = String.format("%.2f", checkoutPage.getTotalPrice());
        Assert.assertEquals(result, totalPriceFromPage,
                "Prices does not match!");
    }
}
