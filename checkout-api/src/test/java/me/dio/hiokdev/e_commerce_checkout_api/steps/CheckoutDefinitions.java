package me.dio.hiokdev.e_commerce_checkout_api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import me.dio.hiokdev.e_commerce_checkout_api.resource.checkout.CheckoutRequest;
import me.dio.hiokdev.e_commerce_checkout_api.util.UUIDUtil;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@CucumberContextConfiguration
public class CheckoutDefinitions extends CucumberSpringIntegrationTest {

    @MockBean
    private UUIDUtil uuidUtil;

    private String responseBody;
    private HttpHeaders responseHeaders;
    private HttpStatusCode statusCode;

    @Given("generate uuid {string}")
    public void generateUuid(String uuid) {
        when(uuidUtil.createUUID()).thenReturn(UUID.fromString(uuid));
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
        assertThat(responseBody).isEqualTo(expectedResponse);
    }

}
