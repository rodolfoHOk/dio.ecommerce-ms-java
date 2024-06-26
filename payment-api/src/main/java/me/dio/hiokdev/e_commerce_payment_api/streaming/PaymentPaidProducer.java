package me.dio.hiokdev.e_commerce_payment_api.streaming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_payment_api.payment.event.PaymentPaidEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentPaidProducer {

    private final StreamBridge streamBridge;

    public void send(PaymentPaidEvent paymentPaidEvent) {
        var result = streamBridge.send("paymentPaidEventSupplier-out-0", paymentPaidEvent);
        if (!result) {
            throw new IllegalStateException("Error when try to send message to broker");
        }
        log.info(String.format("#### -> Producing message: paymentCode: -> %s", paymentPaidEvent.getPaymentCode()));
    }

}
