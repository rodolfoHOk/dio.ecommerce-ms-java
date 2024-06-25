package me.dio.hiokdev.e_commerce_checkout_api.resource.checkout;

import lombok.RequiredArgsConstructor;
import me.dio.hiokdev.e_commerce_checkout_api.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;

    @CrossOrigin(origins = "*")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
        var entity = checkoutService.create(checkoutRequest);
        return entity.map(e -> ResponseEntity.status(HttpStatus.CREATED).body(CheckoutMapper.toResponse(e)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).build());
    }

}
