package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Check that cart contain added products")
    public void addedProductsToCartShouldBeContained() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductsToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductsToCart("Sauce Labs Fleece Jacket");
        cartPage.open();

        Assert.assertTrue(cartPage.cartPageIsOpened(), "Cart page is not opened!");

        Assert.assertEquals(cartPage.getShoppingCartElementItemLabel("Sauce Labs Bolt T-Shirt"),
                "Sauce Labs Bolt T-Shirt",
                "Product label does not match with origin or does not exist in cart");

        Assert.assertEquals(cartPage.getShoppingCartElementItemLabel("Sauce Labs Fleece Jacket"),
                "Sauce Labs Fleece Jacket",
                "Product label does not match with origin or does not exist in cart");
    }

    @Test(retryAnalyzer = Retry.class, description = "Proceeding to checkout")
    public void proceedToCheckoutFromProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openProductPageByLink("Sauce Labs Bike Light");
        productsPage.addProductToCartProduct();
        cartPage.open();

        Assert.assertTrue(cartPage.cartPageIsOpened(), "Cart page is not opened!");

        cartPage.checkout();
        checkoutPage.addFirstName("alex");
        checkoutPage.addLastName("fifa");
        checkoutPage.addPostal("220000");
        checkoutPage.clickContinueToGoToOverview();
        checkoutPage.clickFinish();

        Assert.assertTrue(checkoutPage.isPageOpened(), "Finish page is onot opened!");
        Assert.assertEquals(checkoutPage.orderCompleteText(),
                "THANK YOU FOR YOUR ORDER",
                "Order filed!");
    }
}
