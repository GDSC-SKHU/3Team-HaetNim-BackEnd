package com.example.mini_project_b.login.domain.DTO;


import com.example.mini_project_b.login.domain.Member;

import lombok.Data;

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
                .build();
    }
}
