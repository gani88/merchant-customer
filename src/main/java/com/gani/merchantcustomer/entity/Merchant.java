package com.gani.merchantcustomer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "m_merchant")
@Builder(toBuilder = true)
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name="phone", unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "merchant")
    private List<ProductPrice> productPrices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;
}
