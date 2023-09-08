package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProviderRepositoryTest {

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void relationshipTest1() {
        //g
        Provider provider = new Provider("신진물산");
        providerRepository.save(provider);

        Product product1 = new Product("가위", 5000, 500);
        product1.setProvider(provider);
        Product product2 = new Product("연필", 3000, 300);
        product2.setProvider(provider);
        Product product3 = new Product("지우개", 2000, 200);
        product3.setProvider(provider);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //w
        Product foundProduct1 = productRepository.findById(1L).orElseThrow();
        Product foundProduct2 = productRepository.findById(2L).orElseThrow();
        Product foundProduct3 = productRepository.findById(3L).orElseThrow();
        Provider foundProvider = providerRepository.findById(1L).orElseThrow();

        //t
        System.out.println("foundProduct1 = " + foundProduct1);
        System.out.println("foundProduct2 = " + foundProduct2);
        System.out.println("foundProduct3 = " + foundProduct3);
        assertThat(foundProduct1.getProvider()).isEqualTo(foundProvider);
        assertThat(foundProduct2.getProvider()).isEqualTo(foundProvider);
        assertThat(foundProduct3.getProvider()).isEqualTo(foundProvider);
    }

    @Test
    void relationshipTest2() {
        //g
        Provider provider = new Provider("신진물산");
        providerRepository.save(provider);

        Product product1 = new Product("가위", 5000, 500);
        product1.setProvider(provider);
        Product product2 = new Product("연필", 3000, 300);
        product2.setProvider(provider);
        Product product3 = new Product("지우개", 2000, 200);
        product3.setProvider(provider);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //w
        List<Product> productList = providerRepository.findById(provider.getId()).orElseThrow().getProductList();

        //t
        System.out.println("productList = " + productList);
    }
}
