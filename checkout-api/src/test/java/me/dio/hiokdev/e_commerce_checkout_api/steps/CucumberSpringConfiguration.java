package me.dio.hiokdev.e_commerce_checkout_api.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import me.dio.hiokdev.e_commerce_checkout_api.SpringIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberSpringConfiguration extends SpringIntegrationTest {

    @Test
    void testContainer() {
        assertThat(postgres.isRunning()).isTrue();
    }

}
