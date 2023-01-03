package com.example.mini_project_b.login.domain.DTO;

import lombok.Data;

@Data
public class MemberLoginRequestDto {
    private String memberId;
    private String password;
}
