package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.xpath("//*[@class='btn_primary cart_button']");
    public static final By FINISH_BUTTON = By.xpath("//*[@class='btn_action cart_button']");
    public static final By ORDER_COMPLETE_TEXT = By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void addPostal(String postalCode) {
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    public void clickContinueToGoToOverview() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String orderCompleteText() {
        return driver.findElement(ORDER_COMPLETE_TEXT).getText();
    }
}
