package me.dio.hiokdev.e_commerce_payment_api.config;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class StreamingConfig {

    @Bean
    public Serde<CheckoutCreatedEvent> avroInSerde() {
        return new SpecificAvroSerde<>();
    }

    @Bean
    public Consumer<KStream<CheckoutCreatedEvent, CheckoutCreatedEvent>> checkoutCreatedEventConsumer() {
        return stream -> stream.peek((key, value) -> log
                .info(String.format("#### -> Consuming message: checkoutCode: -> %s", value.getCheckoutCode())));
    }

}
