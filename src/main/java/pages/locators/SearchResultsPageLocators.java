package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultsPageLocators {

    @FindBy(how= How.XPATH, using = "//span[text()='Search results']")
    public WebElement searchResultsTitle;
    @FindBy(how=How.XPATH,using = "//div[@class='srp-list']//div")
    public List<WebElement> searchResults;
}
