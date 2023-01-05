package com.example.mini_project_b.login.repository;

import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMember(Member member);
}
