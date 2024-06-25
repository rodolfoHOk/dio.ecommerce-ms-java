package me.dio.hiokdev.e_commerce_checkout_api.resource.checkout;

import lombok.Builder;

public record CheckoutResponse(
        String code
) {

    @Builder
    public CheckoutResponse {}

}
