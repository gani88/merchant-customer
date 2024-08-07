package com.gani.merchantcustomer.repository;

import com.gani.merchantcustomer.constant.Status;
import com.gani.merchantcustomer.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
    Optional<ProductPrice> findByProduct_IdAndStatus(String productId, Status status);

    @Modifying
    @Query("update m_product_price p set p.status=:status where p.id=:id")
    void updateStatus(Status status, String id);

    @Modifying
    @Query("update m_product_price p set p.stock=:stock where p.id=:id")
    void updateStock(Integer stock, String id);
}
