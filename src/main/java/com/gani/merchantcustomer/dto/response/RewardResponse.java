package com.gani.merchantcustomer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RewardResponse {

    private String id;

    private String reward;
    private LocalDateTime pointRedeemedDate;
}
