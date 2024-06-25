package me.dio.hiokdev.e_commerce_checkout_api.streaming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StreamingProperties {

    @Value("${app.topic.checkout-created}")
    private String checkoutCreatedTopic;

//    @Value("${app.topic.payment-paid}")
//    private String paymentPaidTopic;

}
