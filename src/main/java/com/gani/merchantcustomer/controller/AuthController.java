package com.gani.merchantcustomer.controller;

import com.gani.merchantcustomer.constant.URLPath;
import com.gani.merchantcustomer.dto.request.LoginRequest;
import com.gani.merchantcustomer.dto.request.RegisterCustomerRequest;
import com.gani.merchantcustomer.dto.request.RegisterMerchantRequest;
import com.gani.merchantcustomer.dto.response.SuccessResponse;
import com.gani.merchantcustomer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(URLPath.BASE_AUTH)
public class AuthController {

    private final AuthService authService;


    public ResponseEntity<?> registerCustomer(@Validated @RequestBody RegisterCustomerRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        SuccessResponse.builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("Customer created successfully")
                                .data(authService.registerCustomer(request))
                                .build()
                );
    }

    @PostMapping(URLPath.REGISTER_MERCHANT)
    public ResponseEntity<?> registerMerchant(@Validated @RequestBody RegisterMerchantRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        SuccessResponse.builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("Merchat created successfully")
                                .data(authService.registerMerchant(request))
                                .build()
                );
    }

    @PostMapping(URLPath.LOGIN)
    public ResponseEntity<?> login(@Validated @RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        SuccessResponse.builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("Login Success")
                                .data(authService.login(request))
                                .build()
                );
    }
}
