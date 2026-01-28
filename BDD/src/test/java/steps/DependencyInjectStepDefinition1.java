package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DependencyInjectStepDefinition1 {
    String cart_id;

    @Given("I should be at the product page")
    public void i_should_be_at_the_product_page() {
        System.out.println("Given statement");
    }

    @When("I click on add to cart button")
    public void i_click_on_add_to_cart_button() {
        System.out.println("Add to cart clicked");

        cart_id = "sdfkjsdh-f23984u3-2dsjahdk-jdh2398";
    }

    @Then("Product should get added to cart")
    public void product_should_get_added_to_cart() {
        System.out.println("Product Added!!");
    }

    public String getCartId() {
        return cart_id;
    }
}