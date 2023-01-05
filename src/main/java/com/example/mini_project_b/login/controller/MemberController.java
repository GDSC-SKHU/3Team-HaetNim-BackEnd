package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.DTO.LoginDTO;
import com.example.mini_project_b.login.domain.DTO.MemberJoinDto;
import com.example.mini_project_b.login.domain.DTO.TokenDTO;
import com.example.mini_project_b.login.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("admin");
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("user");
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO memberLoginRequestDTO) {
        String memberID = memberLoginRequestDTO.getMemberId();
        String password = memberLoginRequestDTO.getPassword();
        TokenDTO tokenDTO = memberService.login(memberID, password);
        return tokenDTO;
    }
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto memberJoinDto) {
        memberService.join(memberJoinDto);
        return ResponseEntity.ok("가입성공");
    }

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("index");
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

}