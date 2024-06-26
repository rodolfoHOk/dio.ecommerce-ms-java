package me.dio.hiokdev.e_commerce_checkout_api.config;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import org.apache.kafka.common.serialization.Serde;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Configuration
public class StreamingConfig {

    @Bean
    public Serde<CheckoutCreatedEvent> avroInSerde() {
        return new SpecificAvroSerde<>();
    }

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

}
