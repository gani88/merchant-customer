package com.gani.merchantcustomer.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerRequest {

    @NotBlank(message = "you must provide a name")
    private String name;

    @NotBlank(message = "you must provide an email")
    private String email;

    @NotBlank(message = "you must provide a username")
    private String username;

    @NotBlank(message = "you must provide a password")
    private String password;

    @NotBlank(message = "you must provide a phone number")
    private String phone;

    @NotBlank(message = "you must provide an address")
    private String address;
}
