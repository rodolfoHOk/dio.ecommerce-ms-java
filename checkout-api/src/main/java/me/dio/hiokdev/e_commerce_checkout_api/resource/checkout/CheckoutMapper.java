package me.dio.hiokdev.e_commerce_checkout_api.resource.checkout;

import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;

public abstract class CheckoutMapper {
    public static CheckoutResponse toResponse(CheckoutEntity entity) {
        return CheckoutResponse.builder()
                .code(entity.getCode())
                .build();
    }
}
