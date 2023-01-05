package com.example.mini_project_b.login.domain.DTO;


import com.example.mini_project_b.login.domain.Member;

import com.example.mini_project_b.login.domain.Role;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class MemberJoinDto {
    private String memberId;
    private String password;
    private String nickname;

    private String statusMessage;

    private String profileImg;

    public Member toEntity() {
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .nickname(nickname)
                .statusMessage(statusMessage)
                .profileImg(profileImg)
                .roles(Collections.singletonList("USER"))
                .build();
    }


}
