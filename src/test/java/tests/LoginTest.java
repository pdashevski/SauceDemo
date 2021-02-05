package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }

    @Test
    public void emptyUsernameAndPassword() {
        loginPage.open();
        loginPage.login("", "");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is not correct");
    }
}