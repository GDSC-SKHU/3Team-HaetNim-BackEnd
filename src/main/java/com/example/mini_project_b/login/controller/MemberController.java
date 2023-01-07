package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.DTO.LoginDTO;
import com.example.mini_project_b.login.domain.DTO.MemberJoinDto;
import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.DTO.TokenDTO;
import com.example.mini_project_b.login.service.MemberService;
import com.example.mini_project_b.login.service.PostHashtagService;
import com.example.mini_project_b.login.service.PostLikeService;
import com.example.mini_project_b.login.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;

    private final PostLikeService postLikeService;

    private final PostHashtagService postHashtagService;


    // ---- User와 Admin 권한을 가진 사용자를 확인하기 위한 임시 api ----
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("admin page");
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("user page");
    }

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("index");
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    //--------------------------------------------------



    // 로그인을 진행할 수 있도록 하는 POST api
    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO loginRequestDTO)
    {
        return memberService.login(loginRequestDTO);
    }

    // 회원가입을 진행할 수 있도록 하는 POST api
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto memberJoinDto) {
        memberService.join(memberJoinDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 메인화면에 출력될 수 있는 GET api
    @GetMapping("/main")
    public ResponseEntity<List<PostDTO>> mainFindAll(
            Principal principal
    ){
        List<PostDTO> responses =
            postHashtagService.findAllHashtags(
                postLikeService.findAllPostLike(
                        principal,
                        postService.findAllisDisclosure()
                )
            );

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .ok(responses);
    }

    // {memberId}의 프로필과 게시물을 모두 출력해주는 GET api
    @GetMapping("/@{memberId}")
    public ResponseEntity<MemberJoinDto> findAllByTeamId(
            Principal principal,
            @PathVariable("memberId") String memberId
    ){
        MemberJoinDto member = memberService.findByUserPostId(memberId);

        List<PostDTO> responses = postService.findAllByMemberId(principal, memberId);


        member.setPostDTOs(responses);

//        if (responses.isEmpty()) {
//            return ResponseEntity
//                    .noContent()
//                    .build();
//        }

        return ResponseEntity
                .ok(member);
    }

    // {memberId}의 게시물을 응답하는 GET api
    @GetMapping("/@{memberId}/{postId}")
    public ResponseEntity<PostDTO> findByPostId(
            Principal principal,
            @PathVariable("memberId") String memberId,
            @PathVariable("postId") Long postId
    ) {
        PostDTO response = postService.findByMemberId(principal, memberId,postId);

        return ResponseEntity
                .ok(response);
    }
}