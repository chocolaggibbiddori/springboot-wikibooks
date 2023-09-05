package com.chocola.springboot.data.repository.support;

import com.chocola.springboot.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);
}
