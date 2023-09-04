package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        //g
        Product product = new Product("pen", 1000, 2000);

        //w
        Product savedProduct = productRepository.save(product);

        //t
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStock(), savedProduct.getStock());
    }

    @Test
    void selectTest() {
        //g
        Product product = new Product("pen", 1000, 2000);
        Product savedProduct = productRepository.save(product);

        //w
        Product foundProduct = productRepository.getById(savedProduct.getId());

        //t
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());
    }

    @Test
    void conditionTest() {
        //g
        productRepository.save(new Product("pen", 1000, 2000, LocalDateTime.now(), LocalDateTime.now()));
        productRepository.save(new Product("eraser", 1500, 1000, LocalDateTime.now(), LocalDateTime.now()));
        productRepository.save(new Product("pencil", 500, 2200, null, LocalDateTime.now()));
        productRepository.save(new Product("foo", 750, 1800, null, LocalDateTime.now()));
        productRepository.save(new Product("bao", 345, 1234, null, null));
        productRepository.save(new Product("what", 789, 5678, null, null));

        //w
        List<Product> byUpdatedAtIsNull = productRepository.findByUpdatedAtIsNull();
        List<Product> byUpdatedAtNotNull = productRepository.findByUpdatedAtNotNull();
        Product byNameStartsWith = productRepository.findFirstByNameStartsWith("era");

        //t
        assertThat(byUpdatedAtIsNull.size()).isEqualTo(2);
        assertThat(byUpdatedAtNotNull.size()).isEqualTo(4);
        assertThat(byNameStartsWith.getName()).isEqualTo("eraser");
    }

    @Test
    void orderByTest() {
        //g
        productRepository.save(new Product("pen", 1000, 6000));
        productRepository.save(new Product("pen", 2000, 5000));
        productRepository.save(new Product("pen", 3000, 4000));
        productRepository.save(new Product("pen", 4000, 3000));
        productRepository.save(new Product("pen", 5000, 2000));
        productRepository.save(new Product("pen", 6000, 1000));
        productRepository.save(new Product("eraser", 1000, 4000));
        productRepository.save(new Product("eraser", 2000, 3000));
        productRepository.save(new Product("eraser", 3000, 2000));
        productRepository.save(new Product("eraser", 4000, 1000));

        //w
        List<Product> byNameOrderByPrice = productRepository.findByNameOrderByPrice("pen");
        List<Product> byNameOrderByPriceAsc = productRepository.findByNameOrderByPriceAsc("pen");
        List<Product> byNameOrderByPriceDesc = productRepository.findByNameOrderByPriceDesc("pen");
        List<Product> allByOrderByNamePrice = productRepository.findAllByOrderByNameAscPrice();

        //t
        System.out.println("byNameOrderByPrice = " + byNameOrderByPrice);
        System.out.println("byNameOrderByPriceAsc = " + byNameOrderByPriceAsc);
        System.out.println("byNameOrderByPriceDesc = " + byNameOrderByPriceDesc);
        System.out.println("allByOrderByNamePrice = " + allByOrderByNamePrice);
        assertThat(byNameOrderByPrice.get(0).getPrice()).isEqualTo(1000);
        assertThat(byNameOrderByPriceAsc.get(0).getPrice()).isEqualTo(1000);
        assertThat(byNameOrderByPriceDesc.get(0).getPrice()).isEqualTo(6000);
        assertThat(allByOrderByNamePrice.get(0).getName()).isEqualTo("eraser");
        assertThat(allByOrderByNamePrice.get(0).getPrice()).isEqualTo(1000);
    }

    @Test
    void sortingAndPagingTest() {
        //g
        Product product1 = new Product("펜", 1000, 100);
        Product product2 = new Product("펜", 5000, 300);
        Product product3 = new Product("펜", 500, 50);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //w
        List<Product> list1 = productRepository.findByName("펜", Sort.by("price", "stock"));
        List<Product> list2 = productRepository.findByName("펜", Sort.by(Sort.Direction.DESC, "price", "stock"));
        List<Product> list3 = productRepository.findByName("펜", Sort.by(Order.desc("price"), Order.asc("stock")));

        //t
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);
    }

    @Test
    void pagingTest() {
        //g
        productRepository.save(new Product("pen", 1000, 6000));
        productRepository.save(new Product("pen", 2000, 5000));
        productRepository.save(new Product("pen", 3000, 4000));
        productRepository.save(new Product("pen", 4000, 3000));
        productRepository.save(new Product("pen", 5000, 2000));
        productRepository.save(new Product("pen", 6000, 1000));
        productRepository.save(new Product("eraser", 1000, 4000));
        productRepository.save(new Product("eraser", 2000, 3000));
        productRepository.save(new Product("eraser", 3000, 2000));
        productRepository.save(new Product("eraser", 4000, 1000));

        //w
        Page<Product> list = productRepository.findAll(PageRequest.of(1, 2, Sort.by("price")));

        //t
        System.out.println(list);
        System.out.println(list.getContent());
        System.out.println(list.getTotalElements());
        System.out.println(list.getTotalPages());
    }
}
