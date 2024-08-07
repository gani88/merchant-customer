package com.gani.merchantcustomer.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductUpdateRequest {

    @NotBlank(message = "you must provide an id")
    private String id;

    @NotBlank(message = "you must provide a name")
    private String name;

    @NotBlank(message = "you must provide a description")
    private String description;

    @NotNull(message = "you must provide a price")
    private Long price;

    @NotNull(message = "you must provide a stock")
    private Integer stock;
}
