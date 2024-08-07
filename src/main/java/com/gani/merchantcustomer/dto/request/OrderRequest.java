package com.gani.merchantcustomer.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderRequest {

    @NotEmpty(message = "orderDetailRequestList cannot be empty")
    private List<@Valid OrderDetailRequest> orderDetailRequestList;
}
