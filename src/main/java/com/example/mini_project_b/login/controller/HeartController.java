package com.example.mini_project_b.login.controller;


import com.example.mini_project_b.login.domain.DTO.HeartResponseDto;
import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class HeartController {
    private final HeartService heartService;

    // 조회 [Get] 요청받는 DTO 없음. 반환할 DTO 있음

    // 등록 [POST] 요청받는 DTO 있음. 반환할 DTO 있음
    // 수정 [PATCH(o), PUT] 요청 DTO 있음. 반환 DTO 있음

    // 삭제 [DELETE] 요청 DTO 없음. 반환 DTO 없음.

    //하트 카운트 1증가
    @PostMapping("/{postId}/like")
    public ResponseEntity<HeartResponseDto> like(@PathVariable Long postId,
                               @AuthenticationPrincipal Member userDetails) {
        int heartCount = heartService.saveLikes(postId, userDetails);
        HeartResponseDto heartResponseDto = new HeartResponseDto(heartCount);
        return ResponseEntity.ok(heartResponseDto);
    }

    //하트 카운트 1감소
    @DeleteMapping("/{postId}/delete")
    public ResponseEntity<HeartResponseDto> remove(@PathVariable Long postId, @AuthenticationPrincipal Member userDetails) {
        int heartCount = heartService.deleteLikes(postId, userDetails);
        HeartResponseDto heartResponseDto = new HeartResponseDto(heartCount);
        return ResponseEntity.ok(heartResponseDto);
    }
}
