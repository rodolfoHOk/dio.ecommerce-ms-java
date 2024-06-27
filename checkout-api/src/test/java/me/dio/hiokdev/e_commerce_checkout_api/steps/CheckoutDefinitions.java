package me.dio.hiokdev.e_commerce_checkout_api.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import me.dio.hiokdev.e_commerce_checkout_api.ECommerceCheckoutApiApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {ECommerceCheckoutApiApplication.class})
public class CheckoutDefinitions {

    @Given("checkout code {string}")
    public void checkoutCode(String code) {

    }

    @When("the client calls {string}")
    public void theClientCalls(String path) {

    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int expectedStatusCode) {

    }

    @And("response is {string}")
    public void responseIs(String expectedResponse) {

    }

}
