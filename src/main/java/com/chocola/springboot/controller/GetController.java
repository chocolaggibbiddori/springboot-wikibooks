package com.chocola.springboot.controller;

import com.chocola.springboot.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/get-api")
@RestController
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        return "Flature";
    }

    @GetMapping("/variable1/{str}")
    public String getVariable1(@PathVariable String str) {
        return str;
    }

    @GetMapping("/variable2/{str}")
    public String getVariable2(@PathVariable("strdf") String string) {
        return string;
    }

    @ApiOperation(value = "GET 메서드 예제", notes = "@requestParam을 활용한 GET Method")
    @GetMapping("/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = false) @RequestParam(required = false) String email,
            @ApiParam(value = "회사", required = false) @RequestParam(required = false, defaultValue = "default") String organization) {
        return name + ", " + email + ", " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();
        paramMap.entrySet().forEach(e -> sb.append(e).append("\n"));
        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
