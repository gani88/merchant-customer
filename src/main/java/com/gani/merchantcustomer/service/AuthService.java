package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.dto.request.LoginRequest;
import com.gani.merchantcustomer.dto.request.RegisterCustomerRequest;
import com.gani.merchantcustomer.dto.request.RegisterMerchantRequest;
import com.gani.merchantcustomer.dto.response.LoginResponse;
import com.gani.merchantcustomer.dto.response.RegisterResponse;
import com.gani.merchantcustomer.entity.UserAccount;

public interface AuthService {

    RegisterResponse registerCustomer(RegisterCustomerRequest request);
    RegisterResponse registerMerchant(RegisterMerchantRequest request);
    LoginResponse login(LoginRequest request);
    void validateNotAuthenticated(UserAccount userAccount);
}
