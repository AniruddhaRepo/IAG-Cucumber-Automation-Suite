package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;
import pages.actions.HomePageActions;
import pages.actions.SearchResultsPageAction;
import utils.BaseUtils;
import utils.DriverManager;

import java.io.IOException;

public class SearchSteps {
    public SoftAssert sa = new SoftAssert();

    @Before
    public void launchApplication() throws IOException {
        DriverManager.setUpDriver();
    }

    @After
    public void tearDown() {
        DriverManager.getDriver().quit();
    }

    @AfterStep
    public void captureScreenshots(Scenario scneario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scneario.attach(screenshot, "image/png", "image");
    }

    @Given("I navigate to the PwC Digital Pulse website")
    public void i_navigate_to_the_pwc_digital_pulse_website() {
        sa.assertTrue(HomePageActions.isLandedOnHomePage());
    }

    @When("I click on the Magnifying Glass icon to perform a search")
    public void i_click_on_the_Magnifying_Glass_icon_to_perform_a_search() {
        HomePageActions.clickOnSearchButton();
    }

    @When("I enter the text {string}")
    public void i_enter_the_text(String spa) {
        HomePageActions.enterTextOnSearchTextBox(spa);

    }

    @When("I submit the search")
    public void i_submit_the_search() {
        HomePageActions.submitSearchText();

    }

    @Then("I am taken to the search results page")
    public void i_am_taken_to_the_search_results_page() {
        sa.assertTrue(SearchResultsPageAction.isLandedOnSearchResultPage());
        sa.assertAll();

    }

    @Then("I am presented with at least one search result")
    public void i_am_presented_with_at_least_search_result() {
        SearchResultsPageAction.validateCountOfSearchResult();

    }

}
