package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.DTO.MemberLoginRequestDto;
import com.example.mini_project_b.login.domain.DTO.TokenInfo;
import com.example.mini_project_b.login.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        //String memberId = memberLoginRequestDto.getMemberId();
        //String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberLoginRequestDto);
        return tokenInfo;
    }
    @PostMapping("/test")
    public String test() {
        return "success";
    }
}
