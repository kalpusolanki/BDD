package uiappfeaturesteps;

import drivermanager.Driverfactory;
import drivermanager.PageFactoryManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import uiappfeaturePages.SearchPage;

public class SearchProductSteps {
    SearchPage searchPage;
    public SearchProductSteps(){
        searchPage=new PageFactoryManager().getSearchPageObject(Driverfactory.getDriver());
    }

    @When("user searches {string} in text box")
    public void searchOnPageStep(String valueToBeSearched)
    {
        searchPage.searchPhone(valueToBeSearched);

    }

    @Then("mobile search results should display")
    public void validateResultsOnPage()
    {
        boolean isPresent = searchPage.validateResult();

        Assert.assertEquals(isPresent, true);
    }
}
