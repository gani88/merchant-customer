package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.dto.response.UserResponse;
import com.gani.merchantcustomer.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDetails loadByUserId(Integer id);

    UserResponse getById(Integer id);

    UserAccount getUserByCustomerId(String id);

    UserAccount getUserByMerchantId(String id);

    UserAccount getUserByUsername(String username);
}
