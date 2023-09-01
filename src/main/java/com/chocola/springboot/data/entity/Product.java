package com.chocola.springboot.data.entity;

import com.chocola.springboot.data.dto.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
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

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.stock = productDto.getStock();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
