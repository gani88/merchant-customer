package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.dto.request.RegisterMerchantRequest;
import com.gani.merchantcustomer.dto.response.DefaultMerchantResponse;
import com.gani.merchantcustomer.dto.response.MerchantResponse;
import com.gani.merchantcustomer.entity.Merchant;
import com.gani.merchantcustomer.entity.UserAccount;

import java.util.List;

public interface MerchantService {
    Merchant create(UserAccount userAccount, RegisterMerchantRequest request);
    Merchant getMerchantById(Integer id);
    Merchant getMerchantByUserId(Integer id);
    MerchantResponse getById(Integer id);
    DefaultMerchantResponse getSimpleById(Integer id);
    List<MerchantResponse> getAll();
    void delete(Integer id);
    void throwIfIdNotExist(Integer id);
    void throwIfNotValidated(RegisterMerchantRequest request);
}
