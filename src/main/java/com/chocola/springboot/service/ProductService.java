package com.chocola.springboot.service;

import com.chocola.springboot.data.dto.ProductDto;
import com.chocola.springboot.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long id);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long id, String name) throws Exception;
    void deleteProduct(Long id) throws Exception;
}
