package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART_BUTTON = "//*[@class='inventory_item']//*[contains(text(),'%s')]" +
            "/ancestor::*[@class='inventory_item']/descendant::*[@class='btn_primary btn_inventory']";
    public static final String REMOVE_FROM_CART_BUTTON = "//*[@class='inventory_item']//*[contains(text(),'%s')]" +
            "/ancestor::*[@class='inventory_item']/descendant::*[@class='btn_secondary btn_inventory']";
    public static final String LABEL_LINK = "//*[text()='%s']";
    public static final String PRODUCT_PRICE_INVENTORY = "//*[text()='%s']//ancestor::*[@class='inventory_item']" +
            "//descendant::*[@class='inventory_item_price']";
    public static final String PRODUCT_PRICE_PRODUCT_PAGE = "//*[@class='inventory_details_price']";
    public static final By ADD_TO_CART_BUTTON_PRODUCT = By.cssSelector(".btn_primary.btn_inventory");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductsToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON, productName))).click();
    }

    public void removeProductsFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_BUTTON, productName))).click();
    }

    public boolean getRemoveFromCartButtonAvailability(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_BUTTON, productName))).isEnabled();
    }

    public void openProductPageByLink(String productName) {
        driver.findElement(By.xpath(String.format(LABEL_LINK, productName))).click();
    }

    public String productPriceInvnentory(String productName) {
        String element = driver.findElements(By.xpath(String.format(PRODUCT_PRICE_INVENTORY, productName))).get(0).getText();
        element = element.replace("$", "");
        return element;
    }

    public String productPriceProductPage() {
        String element = driver.findElements(By.xpath(PRODUCT_PRICE_PRODUCT_PAGE)).get(0).getText();
        element = element.replace("$", "");
        return element;
    }

    public void addProductToCartProduct() {
        driver.findElement(ADD_TO_CART_BUTTON_PRODUCT).click();
    }
}
