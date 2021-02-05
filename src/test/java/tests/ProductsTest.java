package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAvailableInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductsToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductsToCart("Sauce Labs Fleece Jacket");
    }
}
