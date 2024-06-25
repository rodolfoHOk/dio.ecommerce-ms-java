package me.dio.hiokdev.e_commerce_checkout_api.service;

import lombok.RequiredArgsConstructor;
import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;
import me.dio.hiokdev.e_commerce_checkout_api.repository.CheckoutRepository;
import me.dio.hiokdev.e_commerce_checkout_api.resource.checkout.CheckoutRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final var checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        var savedEntity = checkoutRepository.save(checkoutEntity);
        return Optional.of(savedEntity);
    }

}
