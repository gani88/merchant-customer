package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.dto.request.ProductRequest;
import com.gani.merchantcustomer.dto.request.ProductUpdateRequest;
import com.gani.merchantcustomer.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request, String authHeader);

    ProductResponse getById(String id);

    List<ProductResponse> getAll();

    ProductResponse update(ProductUpdateRequest request, String authHeader);
    void updateStock(Integer id, Integer stock);
    void delete(Integer id, String authHeader);
    void throwIfIdNotExist(Integer id);
}
