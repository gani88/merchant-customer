package com.gani.merchantcustomer.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginRequest {

    @NotBlank(message = "you must provide a username")
    private String username;

    @NotBlank(message = "you must provide a password")
    private String password;
}
