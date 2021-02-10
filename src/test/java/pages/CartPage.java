package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static final String CART_ITEMS_LABEL = "//*[@class='cart_item_label']/descendant::*[contains(text(),'%s')]";
    public static final By SHOPPING_CART_ICON = By.cssSelector(".shopping_cart_link");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By YOU_CART_PAGE_LABEL = By.xpath("//*[@class='subheader']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.findElement(SHOPPING_CART_ICON).click();
    }

    public String getShoppingCartElementItemLabel(String productName) {
        return driver.findElement(By.xpath(String.format(CART_ITEMS_LABEL, productName))).getText();
    }

    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean cartPageIsOpened() {
        boolean isOpened;
        try {
            driver.findElement(YOU_CART_PAGE_LABEL).getText();
            isOpened = true;
        } catch (TimeoutException ex) {
            isOpened = false;
        }
        return isOpened;
    }
}
