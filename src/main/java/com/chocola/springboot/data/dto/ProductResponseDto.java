package com.chocola.springboot.data.dto;

import com.chocola.springboot.data.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String name;
    private int price;
    private int stock;

    @Builder
    public ProductResponseDto(Long id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
