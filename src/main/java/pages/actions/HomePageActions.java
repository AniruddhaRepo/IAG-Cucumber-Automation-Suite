package pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.HomePageLocators;
import utils.BaseUtils;
import utils.DriverManager;

public class HomePageActions {
    public static WebDriver driver;
    public static HomePageLocators homePageLocators;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        homePageLocators = new HomePageLocators();
        PageFactory.initElements(this.driver, homePageLocators);
    }

    public static boolean isLandedOnHomePage() {
        BaseUtils.explicitWait(driver, homePageLocators.homePageTitle);
        return homePageLocators.homePageTitle.isDisplayed();
    }

    public static void clickOnSearchButton() {
        BaseUtils.waitTillElementIsClickable(driver,homePageLocators.searchButton);
        homePageLocators.searchButton.click();
    }
    public static void enterTextOnSearchTextBox(String inputText)
    {
        homePageLocators.searchTextBox.clear();
        homePageLocators.searchTextBox.sendKeys(inputText);
    }
    public static void submitSearchText()
    {
        homePageLocators.searchTextBox.sendKeys(Keys.ENTER);
    }
}
