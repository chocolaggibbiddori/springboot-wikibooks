package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
