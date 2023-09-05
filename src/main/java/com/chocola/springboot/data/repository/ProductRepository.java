package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.repository.support.ProductRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    Product findFirstByNameStartsWith(String name);
    List<Product> findByNameOrderByPrice(String name);
    List<Product> findByNameOrderByPriceAsc(String name);
    List<Product> findByNameOrderByPriceDesc(String name);
    List<Product> findAllByOrderByNameAscPrice();
    List<Product> findByName(String name, Sort sort);
    Page<Product> findAll(Pageable pageable); // PagingAndSortingRepository에 이미 정의되어 있음
    @Query("SELECT p FROM Product p Where p.name = ?1")
    List<Product> findByNameParameterBinding(String name);

    @Query("SELECT p FROM Product p Where p.name = :name")
    List<Product> findByNameParameterBindingWithParam(@Param("name") String name);
}
