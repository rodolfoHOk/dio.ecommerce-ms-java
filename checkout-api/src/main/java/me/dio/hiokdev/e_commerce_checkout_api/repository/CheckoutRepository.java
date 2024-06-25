package me.dio.hiokdev.e_commerce_checkout_api.repository;

import me.dio.hiokdev.e_commerce_checkout_api.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

}
