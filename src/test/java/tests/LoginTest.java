package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void correctCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened(); //Assert.fail() in ProductsPage
    }

    @Test(retryAnalyzer = Retry.class)
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyUsernameAndPassword() {
        loginPage.open();
        loginPage.login("", "");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is not correct");
    }
}