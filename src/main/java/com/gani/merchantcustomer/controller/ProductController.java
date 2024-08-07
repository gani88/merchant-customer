package com.gani.merchantcustomer.controller;

import com.gani.merchantcustomer.constant.URLPath;
import com.gani.merchantcustomer.dto.request.ProductRequest;
import com.gani.merchantcustomer.dto.request.ProductUpdateRequest;
import com.gani.merchantcustomer.dto.response.ProductResponse;
import com.gani.merchantcustomer.dto.response.SuccessResponse;
import com.gani.merchantcustomer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(URLPath.BASE_PRODUCT)
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_MERCHANT')")
    public ResponseEntity<?> create(@Validated @RequestBody ProductRequest request,
                                    @RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Create product success")
                        .data(productService.create(request, authHeader))
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Get all product success")
                        .data(productService.getAll())
                        .build());
    }

    @GetMapping(URLPath.ID)
    public ResponseEntity<?> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Get product success")
                        .data(productService.getById(id))
                        .build());
    }

    @PutMapping
    public ResponseEntity<?> update(
            @RequestBody ProductUpdateRequest request,
            @RequestHeader("Authorization") String authHeader
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Update product success")
                        .data(productService.update(request, authHeader))
                        .build());
    }

    @DeleteMapping(URLPath.ID)
    public ResponseEntity<?> delete(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String authHeader
    ) {
        productService.delete(id, authHeader);
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Delete product success")
                        .data(null)
                        .build());
    }
}
