package me.dio.hiokdev.e_commerce_checkout_api.streaming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckoutCreatedProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final StreamingProperties streamingProperties;

    public String send(CheckoutCreatedEvent checkoutCreatedEvent) {
        kafkaTemplate.send(
                streamingProperties.getCheckoutCreatedTopic(),
                checkoutCreatedEvent.getCheckoutCode().toString(),
                checkoutCreatedEvent
        );
        log.info(String.format("#### -> Producing message: checkoutCode: -> %s", checkoutCreatedEvent.getCheckoutCode()));
        return "success";
    }

}
