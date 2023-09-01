package com.chocola.springboot.controller;

import com.chocola.springboot.data.dto.ChangeProductNameDto;
import com.chocola.springboot.data.dto.ProductDto;
import com.chocola.springboot.data.dto.ProductResponseDto;
import com.chocola.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(OK)
    public ProductResponseDto getProduct(Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(OK)
    public ProductResponseDto createProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ProductResponseDto changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
        return productService.changeProductName(changeProductNameDto.getId(), changeProductNameDto.getName());
    }

    @DeleteMapping
    @ResponseStatus(OK)
    public String deleteProduct(Long id) throws Exception {
        productService.deleteProduct(id);
        return "정상적으로 삭제되었습니다.";
    }
}
