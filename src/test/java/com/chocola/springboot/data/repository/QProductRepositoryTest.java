package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.entity.QProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class QProductRepositoryTest {

    @Autowired
    QProductRepository repository;

    @Test
    void querydslTest1() {
        repository.save(new Product("pen", 1000, 6000));
        repository.save(new Product("pen", 5000, 6000));
        repository.save(new Product("pen", 4000, 6000));
        repository.save(new Product("pen", 3000, 6000));
        repository.save(new Product("pen", 2000, 6000));

        QProduct qProduct = QProduct.product;
        Iterable<Product> productList = repository.findAll(
                qProduct.name.containsIgnoreCase("pen")
                        .and(qProduct.price.between(1000, 2500)));

        productList.forEach(System.out::println);
    }
}
