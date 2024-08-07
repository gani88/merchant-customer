package com.gani.merchantcustomer.service.implementation;

import com.gani.merchantcustomer.constant.Status;
import com.gani.merchantcustomer.dto.request.ProductRequest;
import com.gani.merchantcustomer.dto.request.ProductUpdateRequest;
import com.gani.merchantcustomer.dto.response.DefaultMerchantResponse;
import com.gani.merchantcustomer.dto.response.ProductResponse;
import com.gani.merchantcustomer.entity.Merchant;
import com.gani.merchantcustomer.entity.Product;
import com.gani.merchantcustomer.entity.ProductPrice;
import com.gani.merchantcustomer.repository.ProductPriceRepository;
import com.gani.merchantcustomer.repository.ProductRepository;
import com.gani.merchantcustomer.security.JwtUtil;
import com.gani.merchantcustomer.service.MerchantService;
import com.gani.merchantcustomer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;
    private final MerchantService merchantService;
    private final JwtUtil jwtUtil;


    @Override
    public ProductResponse create(ProductRequest request, String authHeader) {
        Map<String, String> userInfo = jwtUtil.getUserInfoByToken(authHeader.substring(7));
        Merchant merchant = merchantService.getMerchantByUserId(Integer.parseInt(userInfo.get("userId")));

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(Status.ACTIVE)
                .build();

        ProductPrice productPrice = ProductPrice.builder()
                .stock(request.getStock())
                .product(product)
                .merchant(merchant)
                .price(request.getPrice())
                .status(Status.ACTIVE)
                .build();
        productPriceRepository.save(productPrice);
        DefaultMerchantResponse merchantResponse = DefaultMerchantResponse.builder()
                .id(merchant.getId())
                .name(merchant.getName())
                .build();

        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(productPrice.getPrice())
                .stock(productPrice.getStock())
                .merchant(merchantResponse)
                .build();
    }

    @Override
    public ProductResponse getById(String id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAll() {
        return List.of();
    }

    @Override
    public ProductResponse update(ProductUpdateRequest request, String authHeader) {
        return null;
    }

    @Override
    public void updateStock(Integer id, Integer stock) {

    }

    @Override
    public void delete(Integer id, String authHeader) {

    }

    @Override
    public void throwIfIdNotExist(Integer id) {

    }
}
