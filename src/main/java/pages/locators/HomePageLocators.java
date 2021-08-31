package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {

    @FindBy(how= How.XPATH,using = "//p[text()='Digital Pulse']")
    public WebElement homePageTitle;
    @FindBy(how= How.XPATH,using = "//div[@class='nav-search search-hide ']//button[text()='Search']")
    public WebElement searchButton;
    @FindBy(how= How.ID,using = "slimSearch")
    public WebElement searchTextBox;







}
