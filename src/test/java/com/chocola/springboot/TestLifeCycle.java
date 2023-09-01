package com.chocola.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
class TestLifeCycle {

    @BeforeAll
    static void beforeAll() {
        log.info("## BeforeAll Annotation 호출 ##");
    }

    @AfterAll
    static void afterAll() {
        log.info("## AfterAll Annotation 호출 ##");
    }

    @BeforeEach
    void setUp() {
        log.info("## BeforeEach Annotation 호출 ##");
    }

    @AfterEach
    void tearDown() {
        log.info("## AfterEach Annotation 호출 ##");
    }

    @Test
    void test1() {
        log.info("## Test1 시작 ##");
    }

    @Test
    void test2() {
        log.info("## Test2 시작 ##");
    }

    @Test
    void test3() {
        log.info("## Test3 시작 ##");
    }
}
