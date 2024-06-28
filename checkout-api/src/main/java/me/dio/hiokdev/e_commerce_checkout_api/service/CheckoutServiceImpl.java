package me.dio.hiokdev.e_commerce_checkout_api.service;

import lombok.RequiredArgsConstructor;
import me.dio.hiokdev.e_commerce_checkout_api.checkout.event.CheckoutCreatedEvent;
import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;
import me.dio.hiokdev.e_commerce_checkout_api.repository.CheckoutRepository;
import me.dio.hiokdev.e_commerce_checkout_api.resource.checkout.CheckoutRequest;
import me.dio.hiokdev.e_commerce_checkout_api.streaming.CheckoutCreatedProducer;
import me.dio.hiokdev.e_commerce_checkout_api.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedProducer checkoutCreatedProducer;
    private final UUIDUtil uuidUtil;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final var checkoutEntity = CheckoutEntity.builder()
                .code(uuidUtil.createUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        final var savedEntity = checkoutRepository.save(checkoutEntity);

        final var checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(savedEntity.getCode())
                .setStatus(savedEntity.getStatus().name())
                .build();
        checkoutCreatedProducer.send(checkoutCreatedEvent);

        return Optional.of(savedEntity);
    }

    @Override
    @Transactional
    public Optional<CheckoutEntity> approve(String checkoutCode) {
        var checkoutEntity = checkoutRepository.findByCode(checkoutCode).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        var updatedCheckout = checkoutRepository.save(checkoutEntity);
        return Optional.of(updatedCheckout);
    }

}
