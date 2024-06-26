package me.dio.hiokdev.e_commerce_checkout_api.repository;

import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

    Optional<CheckoutEntity> findByCode(String code);

}
