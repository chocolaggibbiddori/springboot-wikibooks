package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        //g
        Product product = new Product("pen", 1000, 2000);

        //w
        Product savedProduct = productRepository.save(product);

        //t
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStock(), savedProduct.getStock());
    }

    @Test
    void selectTest() {
        //g
        Product product = new Product("pen", 1000, 2000);
        Product savedProduct = productRepository.save(product);

        //w
        Product foundProduct = productRepository.getById(savedProduct.getId());

        //t
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());
    }
}
