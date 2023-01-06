package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.repository.MemberRepository;
import com.example.mini_project_b.login.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    Member findEntityByMemberId(String member_id){
        return memberRepository.findByMemberId(member_id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 팀은 찾을 수 없습니다."));

    }

    @Transactional
    public PostDTO saveByTeamId(String member_id, PostDTO dto){

        Member member = findEntityByMemberId(member_id);

        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .img(dto.getImg())
                .disclosure(dto.isDisclosure())
                .build();

        return postRepository.save(post).toDTO();
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findAll(){
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(Post::toDTO)
                .collect(Collectors.toList());
    }
}
