package me.dio.hiokdev.e_commerce_checkout_api.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtil {

    public UUID createUUID() {
        return UUID.randomUUID();
    }

}
