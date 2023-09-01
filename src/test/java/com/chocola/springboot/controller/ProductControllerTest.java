package com.chocola.springboot.controller;

import com.chocola.springboot.data.dto.ProductDto;
import com.chocola.springboot.data.dto.ProductResponseDto;
import com.chocola.springboot.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ProductService productService;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        //g
        given(productService.getProduct(123L))
                .willReturn(new ProductResponseDto(123L, "pen", 5000, 2000));

        //w
        String productId = "123";
        mockMvc.perform(get("/product?id=" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        //t
        verify(productService).getProduct(123L);
    }

    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        //g
        given(productService.saveProduct(new ProductDto("pen", 5000, 2000))) // 1. 이 객체를 입력 받으면
                .willReturn(new ProductResponseDto(1L, "pen", 5000, 2000)); // 2. 이 객체를 반환한다.

        //w
        ProductDto productDto = new ProductDto("pen", 5000, 2000);
        String content = mapper.writeValueAsString(productDto);

//        Gson gson = new Gson();
//        String gsonContent = gson.toJson(productDto); <-- 위의 content와 같다.

        mockMvc.perform(
                        post("/product")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)) // 3. Json 데이터를 파싱한 ProductDto 객체를 1.에서 입력한 객체와 동등 비교한다.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        //t
        verify(productService).saveProduct(new ProductDto("pen", 5000, 2000));
    }
}
