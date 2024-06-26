package me.dio.hiokdev.e_commerce_checkout_api.service;

import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;
import me.dio.hiokdev.e_commerce_checkout_api.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> approve(String checkoutCode);

}
