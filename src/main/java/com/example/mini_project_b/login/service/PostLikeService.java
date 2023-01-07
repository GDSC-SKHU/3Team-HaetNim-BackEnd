package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.domain.PostLike;
import com.example.mini_project_b.login.repository.MemberRepository;
import com.example.mini_project_b.login.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final MemberRepository memberRepository;
    private final PostLikeRepository postLikeRepository;
    @Transactional(readOnly = true)
    public List<PostDTO> findByPostLike(Principal principal,List<PostDTO> dto){
        if(principal != null) {
            Member member = memberRepository.findByMemberId(principal.getName())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."));

            List<PostLike> postLikes = postLikeRepository.findPostLikesByMember(member);

            for (PostDTO p : dto) {
                for (PostLike pl : postLikes)
                    if (p.getId() == pl.getPost().getId())
                        p.setPostLike(true);
            }
        }

        return dto;
    }
}
