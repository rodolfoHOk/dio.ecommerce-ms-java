package me.dio.hiokdev.e_commerce_payment_api.repository;

import me.dio.hiokdev.e_commerce_payment_api.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
