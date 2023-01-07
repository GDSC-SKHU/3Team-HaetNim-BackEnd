package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.repository.MemberRepository;
import com.example.mini_project_b.login.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HeartService {

    //    private final HeartRepository heartRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public int saveLikes(Long postId, Member userDetails) {
        Post post = postRepository.findById(postId).orElseThrow(() -> {
            throw new IllegalArgumentException("X");
        });
        return post.addHeartCount();
    }

    @Transactional
    public int deleteLikes(Long postId, Member userDetails) {
        Post post = postRepository.findById(postId).orElseThrow(() -> {
            throw new IllegalArgumentException("X");
        });
        return post.deleteHeartCount();
}}
