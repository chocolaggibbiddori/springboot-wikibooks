package com.chocola.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/exception")
@RestController
public class ExceptionController {

    @GetMapping
    public void getRuntimeException() {
        throw new RuntimeException("getRuntimeException() 메서드 호출");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        log.info("클래스 내 handleException 호출, {}, {}", request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, httpStatus);
    }
}
