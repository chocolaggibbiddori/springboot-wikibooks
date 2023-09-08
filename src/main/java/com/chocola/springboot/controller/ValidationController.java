package com.chocola.springboot.controller;

import com.chocola.springboot.data.dto.ValidRequestDto;
import com.chocola.springboot.data.dto.ValidatedRequestDto;
import com.chocola.springboot.data.group.ValidationGroup1;
import com.chocola.springboot.data.group.ValidationGroup2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequestMapping("/validation")
@RestController
public class ValidationController {

    @ResponseStatus(OK)
    @PostMapping("/valid")
    public String checkValidationByValid(@Valid @RequestBody ValidRequestDto dto) {
        log.info("validRequestDto = {}", dto);
        return dto.toString();
    }

    @ResponseStatus(OK)
    @PostMapping("/validated")
    public String checkValidation(@Validated @RequestBody ValidatedRequestDto dto) {
        log.info("validatedRequestDto = {}", dto);
        return dto.toString();
    }

    @ResponseStatus(OK)
    @PostMapping("/validated/group1")
    public String checkValidation1(@Validated(ValidationGroup1.class) @RequestBody ValidatedRequestDto dto) {
        log.info("validatedRequestDto = {}", dto);
        return dto.toString();
    }

    @ResponseStatus(OK)
    @PostMapping("/validated/group2")
    public String checkValidation2(@Validated(ValidationGroup2.class) @RequestBody ValidatedRequestDto dto) {
        log.info("validatedRequestDto = {}", dto);
        return dto.toString();
    }

    @ResponseStatus(OK)
    @PostMapping("/validated/all-group")
    public String checkValidation3(@Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidatedRequestDto dto) {
        log.info("validatedRequestDto = {}", dto);
        return dto.toString();
    }
}
