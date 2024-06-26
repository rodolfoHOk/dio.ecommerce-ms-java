package me.dio.hiokdev.e_commerce_checkout_api.config;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import me.dio.hiokdev.e_commerce_payment_api.payment.event.PaymentPaidEvent;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class StreamingConfig {

    @Bean
    public BlockingQueue<CheckoutCreatedEvent> checkoutCreatedEventBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public Supplier<CheckoutCreatedEvent> checkoutCreatedEventSupplier(
            BlockingQueue<CheckoutCreatedEvent> checkoutCreatedEventBlockingQueue
    ) {
        return checkoutCreatedEventBlockingQueue::poll;
    }

    @Bean
    public Serde<PaymentPaidEvent> avroInSerde() {
        return new SpecificAvroSerde<>();
    }

    @Bean
    public Consumer<KStream<PaymentPaidEvent, PaymentPaidEvent>> paymentPaidEventConsumer() {
        return stream -> stream.peek((key, value) -> {
            log.info(String.format("#### -> Consuming message: paymentCode: -> %s", value.getPaymentCode()));
        });
    }

}
