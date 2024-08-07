package com.gani.merchantcustomer.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "m_reward")
@Builder(toBuilder = true)
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private com.gani.merchantcustomer.constant.Reward reward;

    @OneToMany(mappedBy = "reward")
    private List<CustomerReward> customerRewards;
}
