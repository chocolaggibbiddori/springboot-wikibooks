package com.chocola.springboot.service;

import com.chocola.springboot.data.dao.ProductDAO;
import com.chocola.springboot.data.dto.ProductDto;
import com.chocola.springboot.data.dto.ProductResponseDto;
import com.chocola.springboot.data.entity.Product;
import com.chocola.springboot.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ProductServiceTest {

    private ProductDAO productDAO = Mockito.mock(ProductDAO.class);
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(productDAO);
    }

    @Test
    void getProductTest() {
        //g
        Product givenProduct = new Product();
        givenProduct.setId(123L);
        givenProduct.setName("펜");
        givenProduct.setPrice(1000);
        givenProduct.setStock(1234);

        Mockito.when(productDAO.selectProduct(123L)).thenReturn(givenProduct);
//        BDDMockito.given(productDAO.selectProduct(123L)).willReturn(givenProduct); // 위와 같음

        //w
        ProductResponseDto productResponseDto = productService.getProduct(123L);

        //t
        Assertions.assertEquals(productResponseDto.getId(), givenProduct.getId());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productDAO).selectProduct(123L);
    }

    @Test
    void saveProductTest() {
        //g
        Mockito.when(productDAO.insertProduct(any(Product.class))).then(returnsFirstArg());

        //w
        ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("pen", 1000, 1234));

        //t
        Assertions.assertEquals(productResponseDto.getName(), "pen");
        Assertions.assertEquals(productResponseDto.getPrice(), 1000);
        Assertions.assertEquals(productResponseDto.getStock(), 1234);

        verify(productDAO).insertProduct(any());
    }
}
