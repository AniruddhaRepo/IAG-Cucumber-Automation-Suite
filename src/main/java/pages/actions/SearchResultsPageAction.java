package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import pages.locators.HomePageLocators;
import pages.locators.SearchResultsPageLocators;
import utils.BaseUtils;

import java.util.Iterator;

public class SearchResultsPageAction {
    public static WebDriver driver;
    public static String parentWindowHandle;
    public static SoftAssert softAssert = new SoftAssert();
    public static SearchResultsPageLocators searchResultsPageLocators;

    public SearchResultsPageAction(WebDriver driver) {
        this.driver = driver;
        searchResultsPageLocators = new SearchResultsPageLocators();
        PageFactory.initElements(this.driver, searchResultsPageLocators);
    }

    public static boolean isLandedOnSearchResultPage() {
        return searchResultsPageLocators.searchResultsTitle.isDisplayed();
    }

    public static void validateCountOfSearchResult() {
        BaseUtils.validateElementCountFromList(driver, searchResultsPageLocators.searchResults);
    }
}
