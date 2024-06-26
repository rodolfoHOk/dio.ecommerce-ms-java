package me.dio.hiokdev.e_commerce_checkout_api.streaming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckoutCreatedProducer {

    private final StreamBridge streamBridge;

    public void send(CheckoutCreatedEvent checkoutCreatedEvent) {
        var result = streamBridge.send("checkoutCreatedEventSupplier-out-0" ,checkoutCreatedEvent);
        if (!result) {
            throw new IllegalStateException("No space in queue is currently available");
        }
        log.info(String.format("#### -> Producing message: checkoutCode: -> %s", checkoutCreatedEvent.getCheckoutCode()));
    }

}
