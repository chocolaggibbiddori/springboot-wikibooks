package com.chocola.springboot.data.dao.impl;

import com.chocola.springboot.data.dao.ProductDAO;
import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Product updateProductName(Long id, String name) throws Exception {
        Optional<Product> findProduct = productRepository.findById(id);

        if (findProduct.isEmpty()) throw new Exception();

        Product product = findProduct.get();
        product.setName(name);
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
