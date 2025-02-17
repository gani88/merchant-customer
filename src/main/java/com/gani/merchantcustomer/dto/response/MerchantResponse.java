package com.gani.merchantcustomer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class MerchantResponse {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
