package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.dto.request.RegisterCustomerRequest;
import com.gani.merchantcustomer.entity.Customer;
import com.gani.merchantcustomer.entity.User;
import com.gani.merchantcustomer.entity.UserAccount;

public interface CustomerService {
    Customer create(UserAccount userAccount, RegisterCustomerRequest request);
}
