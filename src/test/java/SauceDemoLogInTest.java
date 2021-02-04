import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceDemoLogInTest {
    public static final String DRIVER_PATH = "src/test/resources/chromedriver.exe";
    public static final String LOGIN_PAGE = "https://www.saucedemo.com/";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By PRODUCT_LABEL = By.className("product_label");
    public static final By INVENTORY_CONTAINER = By.className("inventory_container");
    public static final By ERROR_MESSAGE = By.xpath("//*[@id='login_button_container']//*[@data-test='error']");

    @Test
    public void logInPageMainElementsShouldBeDisplayed() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        Assert.assertTrue(browser.findElement(USERNAME_INPUT).isEnabled(), "Login input field is NOT displayed");
        Assert.assertTrue(browser.findElement(PASSWORD_INPUT).isEnabled(), "Password input field is NOT displayed");
        Assert.assertTrue(browser.findElement(LOGIN_BUTTON).isEnabled(), "Login button si NOT displayed");
        browser.quit();
    }

    @Test
    public void logInWithStandardUser() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        browser.findElement(USERNAME_INPUT).sendKeys(loginList(0));
        browser.findElement(PASSWORD_INPUT).sendKeys(passwordList());
        browser.findElement(LOGIN_BUTTON).click();
        Assert.assertTrue(browser.findElement(PRODUCT_LABEL).isEnabled(), "Product title is NOT displayed");
        Assert.assertTrue(browser.findElement(INVENTORY_CONTAINER).isEnabled(), "Inventory catalogue is NOT enabled");
        browser.quit();
    }

    @Test
    public void logInWithLockedOutUser() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        browser.findElement(USERNAME_INPUT).sendKeys(loginList(1));
        browser.findElement(PASSWORD_INPUT).sendKeys(passwordList());
        browser.findElement(LOGIN_BUTTON).click();
        Assert.assertEquals(browser.findElement(ERROR_MESSAGE).getText(), "Epic sadface: Sorry, this user has been" +
                " locked out.", "Error is not displayed");
        browser.quit();
    }

    @Test
    public void logInWithProblemUser() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        browser.findElement(USERNAME_INPUT).sendKeys(loginList(2));
        browser.findElement(PASSWORD_INPUT).sendKeys(passwordList());
        browser.findElement(LOGIN_BUTTON).click();
        Assert.assertTrue(browser.findElement(PRODUCT_LABEL).isEnabled(), "Product title is NOT displayed");
        Assert.assertTrue(browser.findElement(INVENTORY_CONTAINER).isEnabled(), "Inventory catalogue is NOT enabled");
        browser.quit();
    }

    @Test
    public void logInWithPerformanceGlitchUser() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        browser.findElement(USERNAME_INPUT).sendKeys(loginList(3));
        browser.findElement(PASSWORD_INPUT).sendKeys(passwordList());
        browser.findElement(LOGIN_BUTTON).click();
        Assert.assertTrue(browser.findElement(PRODUCT_LABEL).isEnabled(), "Product title is NOT displayed");
        Assert.assertTrue(browser.findElement(INVENTORY_CONTAINER).isEnabled(), "Inventory catalogue is NOT enabled");
        browser.quit();
    }

    public static String loginList(int index) {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        String loginListInit = browser.findElement(By.cssSelector(".login_credentials")).getText();
        List<String> myList = new ArrayList<>(Arrays.asList(loginListInit.split("\\n")));
        myList.remove(0); //(0)standard_user    (1)locked_out_user   (2)problem_user  (3)performance_glitch_user
        return myList.get(index);
    }

    public static String passwordList() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(LOGIN_PAGE);
        String passwordListInit = browser.findElement(By.cssSelector(".login_password")).getText();
        List<String> myList = new ArrayList<>(Arrays.asList(passwordListInit.split("\\n")));
        myList.remove(0);
        return myList.get(0);
    }
}
