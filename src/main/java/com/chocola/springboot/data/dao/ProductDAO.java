package com.chocola.springboot.data.dao;

import com.chocola.springboot.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long id);

    Product updateProductName(Long id, String name) throws Exception;

    void deleteProduct(Long id) throws Exception;
}
