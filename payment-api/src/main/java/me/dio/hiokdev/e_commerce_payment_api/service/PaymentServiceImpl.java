package me.dio.hiokdev.e_commerce_payment_api.service;

import lombok.RequiredArgsConstructor;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import me.dio.hiokdev.e_commerce_payment_api.entity.PaymentEntity;
import me.dio.hiokdev.e_commerce_payment_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public Optional<PaymentEntity> pay(CheckoutCreatedEvent checkoutCreatedEvent) {
        // payment process
        final var paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode().toString())
                .code(UUID.randomUUID().toString())
                .build();
        final var savedPayment = paymentRepository.save(paymentEntity);
        return Optional.of(savedPayment);
    }

}
