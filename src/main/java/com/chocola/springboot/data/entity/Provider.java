package com.chocola.springboot.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "provider", fetch = EAGER, cascade = {PERSIST, REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    List<Product> productList = new ArrayList<>();

    public Provider(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return List.copyOf(productList);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProduct(Collection<Product> products) {
        productList.addAll(products);
    }

    public void remove(int idx) {
        productList.remove(idx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider provider)) return false;
        return Objects.equals(id, provider.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
