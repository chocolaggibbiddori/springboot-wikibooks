package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Category;
import com.chocola.springboot.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationshipTest() {
        //g
        Product product = new Product("pen", 2000, 100);
        productRepository.save(product);

        Category category = new Category("S1", "문구");
        category.addProduct(product);
        categoryRepository.save(category);

        //w
        List<Product> productList = categoryRepository.findById(1L).get().getProductList();

        //t
        System.out.println(productList);
    }
}
