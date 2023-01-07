package com.example.mini_project_b.login.domain.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HeartRequestDTO {

    private Long memberId;
    private Long postId;


    public HeartRequestDTO(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
    }
}
