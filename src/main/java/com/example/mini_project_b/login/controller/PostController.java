package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.DTO.MemberJoinDto;
import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.service.MemberService;
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
    private final MemberService memberService;

    // {memberId}의 프로필과 게시물을 모두 출력해주는 GET api
    @GetMapping("/@{memberId}")
    public ResponseEntity<MemberJoinDto> findAllByTeamId(
            @PathVariable("memberId") String memberId
    ){

        MemberJoinDto member = memberService.findByUserPostId(memberId);

        List<PostDTO> responses = postService.findAllByMemberId(memberId);
        member.setPostDTOs(responses);

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .ok(member);
    }

    // {memberId}의 프로필을 수정할 수 있도록 하는 PATCH api
    @PatchMapping("/@{memberId}/update")
    public ResponseEntity<String> updateByUserId(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @RequestBody MemberJoinDto memberJoinDto
    ) {
        memberService.profileUpdate(principal, memberId, memberJoinDto);
        return ResponseEntity.ok(memberId+" 수정 성공");
    }





    // {memberId}의 게시물을 응답하는 GET api
    @GetMapping("/@{memberId}/{postId}")
    public ResponseEntity<PostDTO> findByPostId(
            @PathVariable("memberId") String memberId,
            @PathVariable("postId") Long postId
    ) {

        PostDTO response = postService.findByMemberId(memberId,postId);

        return ResponseEntity
                .ok(response);
    }




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





    // {memberId}의 게시물을 수정 할 수 있도록 하는 PATCH api
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


    // {memberId}의 게시물을 삭제 할 수 있도록 하는 DELETE api
    @DeleteMapping("/@{memberId}/{postId}/delete")
    public ResponseEntity<String> postDelete(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @PathVariable("postId") Long postId) {
        postService.deleteById(principal, memberId, postId);

        // /api/members/id URI 생성
        return ResponseEntity.ok("post Delete success");
    }

    
}
