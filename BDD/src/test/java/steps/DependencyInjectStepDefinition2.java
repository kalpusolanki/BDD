package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DependencyInjectStepDefinition2 {

    DependencyInjectStepDefinition1 apcGlobal;

    public DependencyInjectStepDefinition2(DependencyInjectStepDefinition1 apcLocal)
    {
        apcGlobal = apcLocal;
    }

    @When("I click on place order button")
    public void i_click_on_place_order_button() {
        System.out.println("Clicked on place order");
    }

    @Then("order should get placed")
    public void order_should_get_placed() {

        System.out.println("Order placed validated!!");


        System.out.println("Received cart id is :"+apcGlobal.getCartId());
    }

}
