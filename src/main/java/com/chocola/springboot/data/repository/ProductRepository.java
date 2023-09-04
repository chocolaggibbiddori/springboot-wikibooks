package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    Product findFirstByNameStartsWith(String name);
    List<Product> findByNameOrderByPrice(String name);
    List<Product> findByNameOrderByPriceAsc(String name);
    List<Product> findByNameOrderByPriceDesc(String name);
    List<Product> findAllByOrderByNameAscPrice();
    List<Product> findByName(String name, Sort sort);
}
