package me.dio.hiokdev.e_commerce_checkout_api.resource.checkout;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public record CheckoutRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank String username,
    @Email String email,
    @NotBlank String address,
    String complement,
    @NotBlank String country,
    @NotBlank String state,
    @NotBlank String cep,
    @NotNull Boolean sameAddress,
    @NotNull Boolean saveInfo,
    @NotBlank String paymentMethod,
    @NotBlank String ccName,
    @NotBlank String ccNumber,
    @NotBlank String ccExpiration,
    @NotBlank String ccCvv
) {
    @Builder
    public CheckoutRequest {}
}
