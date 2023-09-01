package com.chocola.springboot.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String name;
    private int price;
    private int stock;

    public ProductDto(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductDto productDto) {
            return this.name.equals(productDto.getName()) &&
                   this.price == productDto.getPrice() &&
                   this.stock == productDto.getStock();
        }

        return false;
    }
}
