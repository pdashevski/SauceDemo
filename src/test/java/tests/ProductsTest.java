package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductsToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductsToCart("Sauce Labs Fleece Jacket");

        Assert.assertTrue(productsPage.getRemoveFromCartButtonAvailability("Sauce Labs Bolt T-Shirt"),
                "REMOVE button is not displayed. Product is not added to cart");
        Assert.assertTrue(productsPage.getRemoveFromCartButtonAvailability("Sauce Labs Fleece Jacket"),
                "REMOVE button is not displayed. Product is not added to cart");
    }

    @Test
    public void checkProductPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String priceInventory = productsPage.productPriceInvnentory("Sauce Labs Onesie");
        productsPage.openProductPageByLink("Sauce Labs Onesie");
        String priceProduct = productsPage.productPriceProductPage();

        Assert.assertEquals(priceInventory, priceProduct, "Prices are not equals!");
    }

    @Test
    public void addProductToCartFromProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openProductPageByLink("Sauce Labs Onesie");
        productsPage.addProductToCartProduct();
        cartPage.open();

        Assert.assertEquals(cartPage.getShoppingCartElementItemLabel("Sauce Labs Onesie"),
                "Sauce Labs Onesie",
                "Product label does not match with origin or does not exist in cart");
    }
}
