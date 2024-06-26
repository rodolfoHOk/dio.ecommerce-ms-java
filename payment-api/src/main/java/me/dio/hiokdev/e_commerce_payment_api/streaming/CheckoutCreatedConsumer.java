package me.dio.hiokdev.e_commerce_payment_api.streaming;

import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheckoutCreatedConsumer {

    @KafkaListener(id = "checkoutCreatedConsumer", topics = "${app.topic.checkout-created}")
    public void consume(ConsumerRecord<String, CheckoutCreatedEvent> checkoutCreatedRecord) {
        log.info(String.format("#### -> Consuming message: checkoutCode: -> %s", checkoutCreatedRecord.value().getCheckoutCode()));
    }

}
