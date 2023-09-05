package com.chocola.springboot.data.repository.support;

import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.data.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct qProduct = QProduct.product;

        return from(qProduct)
                .where(qProduct.name.eq(name))
                .fetch();
    }
}
