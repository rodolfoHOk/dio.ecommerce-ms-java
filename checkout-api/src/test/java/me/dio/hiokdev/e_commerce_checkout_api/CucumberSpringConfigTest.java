package me.dio.hiokdev.e_commerce_checkout_api;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {ECommerceCheckoutApiApplication.class})
public class CucumberSpringConfigTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;

}
