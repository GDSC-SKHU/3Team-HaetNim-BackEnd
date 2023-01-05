package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.DTO.LoginDTO;
import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    // 포스트 생성
    @PostMapping("/{memberId}/add")
    public ResponseEntity<String> save(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @RequestBody PostDTO request) {


        PostDTO response = postService.saveByPostId(principal, memberId, request);

        // /api/members/id URI 생성
        return ResponseEntity.ok("post save success");

    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDTO>> findAllByTeamId(
//            String memberId
            @PathVariable("id") String memberId
    ){

        List<PostDTO> responses = postService.findAllByMemberId(memberId);

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .ok(responses);
    }

    @GetMapping("")
    public ResponseEntity<List<PostDTO>> findAllId(
    ){
        System.out.println("@@@@@@@@@@@@@");

        List<PostDTO> responses = postService.findAll();

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .ok(responses);
    }


}
