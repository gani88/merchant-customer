package com.gani.merchantcustomer.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailRequest {

    @NotNull(message = "productId cannot be blank")
    private String productId;

    @NotNull(message = "quantity cannot be blank")
    @Min(value = 1, message = "quantity cannot be less than 1")
    private Integer quantity;

}
