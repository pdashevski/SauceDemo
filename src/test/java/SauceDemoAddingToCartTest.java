import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemoAddingToCartTest {
    public static final String ADD_BUTTON = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final String CART_ITEMS_LABEL = "//*[@class='cart_item_label']/descendant::*[contains(text(), '%s')]";

    @Test
    public void logInWithStandardUserAndAddingItemsToCart() {
        System.setProperty("webdriver.chrome.driver", SauceDemoLogInTest.DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(SauceDemoLogInTest.LOGIN_PAGE);
        browser.findElement(SauceDemoLogInTest.USERNAME_INPUT).sendKeys(SauceDemoLogInTest.loginList(0));
        browser.findElement(SauceDemoLogInTest.PASSWORD_INPUT).sendKeys(SauceDemoLogInTest.passwordList());
        browser.findElement(SauceDemoLogInTest.LOGIN_BUTTON).click();
        Assert.assertTrue(browser.findElement(SauceDemoLogInTest.PRODUCT_LABEL).isEnabled(), "Products" +
                " title is NOT displayed");
        Assert.assertTrue(browser.findElement(SauceDemoLogInTest.INVENTORY_CONTAINER).isEnabled(), "Inventory" +
                " catalogue is NOT enabled");
        browser.findElement(By.xpath(String.format(ADD_BUTTON, "Sauce Labs Bolt T-Shirt"))).click();
        browser.findElement(By.xpath(String.format(ADD_BUTTON, "Sauce Labs Fleece Jacket"))).click();
        browser.findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertTrue(browser.findElement(By.xpath(String.format(CART_ITEMS_LABEL, "T-shirt"))).isEnabled());
        Assert.assertTrue(browser.findElement(By.xpath(String.format(CART_ITEMS_LABEL, "Jacket"))).isEnabled());
        browser.quit();
    }
}
