package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.DTO.MemberJoinDto;
import com.example.mini_project_b.login.domain.DTO.LoginDTO;
import com.example.mini_project_b.login.domain.DTO.TokenDTO;
import com.example.mini_project_b.login.jwt.TokenProvider;
import com.example.mini_project_b.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Transactional
    public TokenDTO login(String memberId, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDTO tokenDTO = tokenProvider.createToken(authentication);
        return tokenDTO;
    }


    @Transactional
    public void join(MemberJoinDto memberJoinDto) {
        if(memberRepository.findByMemberId(memberJoinDto.getMemberId()).isPresent()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        memberRepository.save(memberJoinDto.toEntity());
    }


}