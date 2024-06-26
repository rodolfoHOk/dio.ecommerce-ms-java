package me.dio.hiokdev.e_commerce_payment_api.service;

import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import me.dio.hiokdev.e_commerce_payment_api.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> pay(CheckoutCreatedEvent checkoutCreatedEvent);

}
