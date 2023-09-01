package com.chocola.springboot.service.impl;

import com.chocola.springboot.data.dao.ProductDAO;
import com.chocola.springboot.data.dto.ProductDto;
import com.chocola.springboot.data.dto.ProductResponseDto;
import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public ProductResponseDto getProduct(Long id) {
        Product product = productDAO.selectProduct(id);
        return new ProductResponseDto(product);
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        Product savedProduct = productDAO.insertProduct(product);
        return new ProductResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto changeProductName(Long id, String name) throws Exception {
        Product product = productDAO.updateProductName(id, name);
        return new ProductResponseDto(product);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        productDAO.deleteProduct(id);
    }
}
