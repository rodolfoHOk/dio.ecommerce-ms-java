package me.dio.hiokdev.e_commerce_checkout_api.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.dio.hiokdev.e_commerce_checkout_api.ECommerceCheckoutApiApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ECommerceCheckoutApiApplication.class})
public abstract class CucumberSpringIntegrationTest {

    @Container
    @ServiceConnection
    protected static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("checkout")
            .withUsername("admin")
            .withPassword("admin");

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected ObjectMapper objectMapper;

//    @Test
//    void testContainer() {
//        assertThat(postgres.isRunning()).isTrue();
//    }

}
