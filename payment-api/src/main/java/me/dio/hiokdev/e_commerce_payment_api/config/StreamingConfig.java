package me.dio.hiokdev.e_commerce_payment_api.config;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.slf4j.Slf4j;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import me.dio.hiokdev.e_commerce_payment_api.payment.event.PaymentPaidEvent;
import me.dio.hiokdev.e_commerce_payment_api.service.PaymentService;
import me.dio.hiokdev.e_commerce_payment_api.streaming.PaymentPaidProducer;
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
    public Serde<CheckoutCreatedEvent> avroInSerde() {
        return new SpecificAvroSerde<>();
    }

    @Bean
    public Consumer<KStream<CheckoutCreatedEvent, CheckoutCreatedEvent>> checkoutCreatedEventConsumer(
            PaymentService paymentService,
            PaymentPaidProducer paymentPaidProducer
    ) {
        return stream -> stream.peek((key, value) -> {
            log.info(String.format("#### -> Consuming message: checkoutCode: -> %s", value.getCheckoutCode()));
            final var payment = paymentService.pay(value).orElseThrow();
            final var paymentPaidEvent = PaymentPaidEvent.newBuilder()
                    .setPaymentCode(payment.getCode())
                    .setCheckoutCode(payment.getCheckoutCode())
                    .build();
            paymentPaidProducer.send(paymentPaidEvent);
        });
    }

    @Bean
    public BlockingQueue<PaymentPaidEvent> paymentPaidEventBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public Supplier<PaymentPaidEvent> paymentPaidEventSupplier(
            BlockingQueue<PaymentPaidEvent> paymentPaidEventBlockingQueue
    ) {
        return paymentPaidEventBlockingQueue::poll;
    }

}
