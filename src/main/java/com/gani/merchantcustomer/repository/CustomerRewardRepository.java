package com.gani.merchantcustomer.repository;

import com.gani.merchantcustomer.entity.CustomerReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRewardRepository extends JpaRepository<CustomerReward, String> {
}
