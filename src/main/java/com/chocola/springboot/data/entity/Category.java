package com.chocola.springboot.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;
    private String name;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "category_id")
    private List<Product> productList = new ArrayList<>();

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return List.copyOf(productList);
    }
}
