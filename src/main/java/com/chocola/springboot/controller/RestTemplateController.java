package com.chocola.springboot.controller;

import com.chocola.springboot.data.dto.MemberDto;
import com.chocola.springboot.service.RestTemplateService;
import com.chocola.springboot.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/rest-template")
@RestController
public class RestTemplateController {

    private final RestTemplateService restTemplateService;
    private final WebClientService webClientService;

    @GetMapping
    public String getName() {
        return webClientService.getName();
    }

    @GetMapping("/path-variable")
    public String getNameWithPathVariable() {
        return webClientService.getNameWithPathVariable();
    }

    @GetMapping("/param")
    public String getNameWithParameter() {
        return webClientService.getNameWithParameter();
    }

    @PostMapping
    public ResponseEntity<MemberDto> postDto() {
        return webClientService.postWithParamAndBody();
    }

    @PostMapping("/header")
    public ResponseEntity<MemberDto> postWithHeader() {
        return webClientService.postWithHeader();
    }
}
