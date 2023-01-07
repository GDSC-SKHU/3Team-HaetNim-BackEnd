package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.domain.PostLike;
import com.example.mini_project_b.login.repository.MemberRepository;
import com.example.mini_project_b.login.repository.PostLikeRepository;
import com.example.mini_project_b.login.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    private final PostLikeRepository postLikeRepository;

    @Transactional
    public int saveLikes(Long postId, Principal principal) {
        System.out.println("!!!!!!!!!!!!"+principal.getName());

        Post post = postRepository.findById(postId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 게시글은 존재하지 않습니다.");
        });
        
        Member member = memberRepository.findByMemberId(principal.getName()).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 사용자는 존재하지 않습니다.");
        });

        List<PostLike> postLikes = postLikeRepository.findByPostId(postId);



        for(PostLike p : postLikes)
            if(p.getMember().getId() == member.getId())
                throw new IllegalArgumentException("이미 좋아요를 누르셨습니다.");

        PostLike postLike = PostLike.builder()
                .post(post)
                .member(member)
                .build();

        postLikeRepository.save(postLike);
//        return post.addHeartCount();
        return 0;
    }

    @Transactional
    public int deleteLikes(Long postId, Member userDetails) {
        Post post = postRepository.findById(postId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 게시글은 존재하지 않습니다.");
        });
//        return post.deleteHeartCount();
        return 0;
    }
}
