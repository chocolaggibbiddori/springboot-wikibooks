package com.chocola.springboot.data.entity;

import com.chocola.springboot.data.dto.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"createdAt", "updatedAt"})
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int stock;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, int price, int stock, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.stock = productDto.getStock();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
