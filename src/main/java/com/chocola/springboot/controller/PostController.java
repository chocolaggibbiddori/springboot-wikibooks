package com.chocola.springboot.controller;

import com.chocola.springboot.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/post-api")
@RestController
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("/member1")
    public String postMember(@RequestBody Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        data.entrySet().forEach(e -> sb.append(e).append("\n"));
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
