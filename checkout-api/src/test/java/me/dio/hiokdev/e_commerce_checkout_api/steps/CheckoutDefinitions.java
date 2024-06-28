package me.dio.hiokdev.e_commerce_checkout_api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import me.dio.hiokdev.e_commerce_checkout_api.resource.checkout.CheckoutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CheckoutDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String responseBody;
    private HttpHeaders responseHeaders;
    private HttpStatusCode statusCode;

    @Given("checkout code {string}")
    public void checkoutCode(String code) {

    }

    @When("the client calls {string}")
    public void theClientCalls(String path) throws JsonProcessingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            final var requestBody = objectMapper.writeValueAsString(CheckoutRequest.builder()
                    .firstName("Test1")
                    .lastName("Tester")
                    .username("test1")
                    .email("test1@email.com")
                    .address("Av Atlantic, 2500")
                    .complement("ap 101")
                    .country("Brazil")
                    .state("São Paulo")
                    .sameAddress(true)
                    .saveInfo(true)
                    .paymentMethod("credit")
                    .ccName("Test1 Tester")
                    .ccNumber("1234567812345678")
                    .ccExpiration("202412")
                    .ccCvv("123")
                    .build());
            var entity = new HttpEntity<>(requestBody, headers);
            final var response = restTemplate.postForEntity(path, entity, String.class);
            responseBody = response.getBody();
            responseHeaders = response.getHeaders();
            statusCode = response.getStatusCode();
        } catch (HttpStatusCodeException ex) {
            statusCode = ex.getStatusCode();
            assertEquals("", ex.getResponseBodyAsString());
        }
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int expectedStatusCode) {
        assertThat(statusCode.value()).isEqualTo(expectedStatusCode);
    }

    @And("response is {string}")
    public void responseIs(String expectedResponse) {

    }

}
