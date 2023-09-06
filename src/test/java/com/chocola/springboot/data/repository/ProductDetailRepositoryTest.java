package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.entity.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveAndReadTest1() {
        //g
        Product product = new Product("스프링 부트 JPA", 5000, 500);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링 부트와 JPA를 함께 볼 수 있는 책");

        productRepository.save(product);
        productDetailRepository.save(productDetail);

        //w
        ProductDetail foundProductDetail = productDetailRepository.findById(productDetail.getId()).get();

        //t
        assertThat(foundProductDetail.getProduct()).isEqualTo(product);
        System.out.println("productDetail = " + foundProductDetail);
        System.out.println("product = " + foundProductDetail.getProduct());
    }
}
