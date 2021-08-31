package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.actions.HomePageActions;
import pages.actions.SearchResultsPageAction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseUtils {
    public static HomePageActions homePageActions = new HomePageActions(DriverManager.getDriver());
    public static SearchResultsPageAction searchResultsPageAction = new SearchResultsPageAction(DriverManager.getDriver());
    public static WebDriverWait wait;
    public static WebDriver popup;
    public static WebElement expectedElement;
    public static SoftAssert sa = new SoftAssert();
    public static Logger log = LogManager.getLogger();

    public BaseUtils() {

    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void explicitWait(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitTillElementIsClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void validateElementCountFromList(WebDriver driver, List<WebElement> elements) {
        int i = 0;
        log.info("Search Results are as follows ");
        Iterator<WebElement> it = elements.iterator();
        while (it.hasNext()) {
            i = i + 1;
            log.info(it.next().getText());
        }
        if (i >= 1) {
            log.info("We got at least one search result for the Keyword");
            log.info("The number of search result we got is "+i);
        }
    }

}
