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
public class PostController {
    private final PostService postService;


    // {memberId}의 게시물을 생성 할 수 있도록 하는 POST api
    @PostMapping("/@{memberId}/add")
    public ResponseEntity<String> postSave(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @RequestBody PostDTO request) {


        PostDTO response = postService.saveByPostId(principal, memberId, request);

        // /api/members/id URI 생성
        return ResponseEntity.ok("post save success");
    }

    // {memberId}의 게시물을 응답하는 GET api
    @GetMapping("/@{memberId}/{postId}")
    public ResponseEntity<PostDTO> findByPostId(
            @PathVariable("memberId") String memberId,
            @PathVariable("postId") Long postId
    ){

        System.out.println();
        PostDTO response = postService.findById(postId);


        return ResponseEntity
                .ok(response);
    }



    // {memberId}의 게시물을 수정 할 수 있도록 하는 POST api
    @PatchMapping("/@{memberId}/{postId}/update")
    public ResponseEntity<String> postUpdate(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @PathVariable("postId") Long postId,
            @RequestBody PostDTO request) {
        PostDTO response = postService.updateById(principal, memberId, postId, request);

        // /api/members/id URI 생성
        return ResponseEntity.ok("post update success");
    }



    // {memberId}의 게시물을 응답해주는 GET api
    @GetMapping("/@{memberId}")
    public ResponseEntity<List<PostDTO>> findAllByTeamId(
//            String memberId
            @PathVariable("memberId") String memberId
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





}
