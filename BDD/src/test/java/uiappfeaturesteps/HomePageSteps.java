package uiappfeaturesteps;

import drivermanager.Driverfactory;
import drivermanager.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import uiappfeaturePages.HomePage;

public class HomePageSteps {
    HomePage homePage;
    WebDriver driver;
    public HomePageSteps(){
        driver=Driverfactory.getDriver();
    homePage=new PageFactoryManager().getHomePageObject(driver);

    }


    @Given("user is at the landing page")
    public void user_is_at_the_landing_page() {

        WebDriver driver = Driverfactory.getDriver();
        driver.get("https://amazon.in");
    }

    @Then("page title should contains {string}")
    public void page_title_should_contains(String string) {

        String title = homePage.getTitleOfPage();

        boolean isWordPresent = title.contains(string);

        Assert.assertEquals(isWordPresent, true);

    }

    @Then("cart icon should get displayed")
    public void cart_icon_should_get_displayed() {
     Assert.assertEquals(homePage.isCartIconIsDisplayed(),true);
    }

    @When("user clicks on soundbar deal")
    public void user_clicks_on_soundbar_deal() {
      homePage.checkOutDealSeaction();
    }

    @Then("user should redirect to deal page")
    public void user_should_redirect_to_deal_page() {
        String textOnPage = homePage.getPageInfo();

        System.out.println(textOnPage);

        boolean isPresentInsideTheText= textOnPage.contains("Brands");

        Assert.assertEquals(isPresentInsideTheText, true);
    }

}
