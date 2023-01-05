package com.example.mini_project_b.login.service;

import com.example.mini_project_b.login.domain.DTO.PostDTO;
import com.example.mini_project_b.login.domain.Member;
import com.example.mini_project_b.login.domain.Post;
import com.example.mini_project_b.login.jwt.TokenProvider;
import com.example.mini_project_b.login.repository.MemberRepository;
import com.example.mini_project_b.login.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    private final TokenProvider tokenProvider;



    // accessToken의 사용자와 {memberId}와 같다면 게시물 생성 가능
    @Transactional
    public PostDTO saveByPostId(Principal principal, String member_id, PostDTO dto){
        if(!member_id.equals(principal.getName()))
//            System.out.println(member_id+" "+principal.getName());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"자신의 블로그에만 등록이 가능합니다.");

        Member member = findEntityByMemberId(member_id);

        System.out.println(member);
        System.out.println(dto.getContent());

        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .img(dto.getImg())
                .disclosure(dto.isDisclosure())
                .member(member)
                .build();

        return postRepository.save(post).toDTO();
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findAllisDisclosure(){
        List<Post> posts = postRepository.findAll();

        for(int i =0; i<posts.size();i++)
            if(!posts.get(i).isDisclosure())
                posts.remove(i);

        return posts.stream()
                .map(Post::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findAllByMemberId(String member_id){
        Member member = findEntityByMemberId(member_id);

        List<Post> posts = postRepository.findAllByMember(member);

        return posts.stream()
                .map(Post::toDTO)
                .collect(Collectors.toList());
    }



    @Transactional(readOnly = true)
    public PostDTO findByMemberId(String member_id, Long id){
        Post post = findEntityById(id);
        if(!member_id.equals(post.getMember().getMemberId()))
//            System.out.println(member_id+" "+principal.getName());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,member_id+"는 이 게시글을 가지고 있지 않습니다.");

        return post.toDTO();
    }

    // accessToken의 사용자와 {memberId}와 같다면 게시물 수정 가능
    @Transactional
    public PostDTO updateById(Principal principal, String member_id,Long id, PostDTO dto){

        if(!member_id.equals(principal.getName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"자신의 블로그에만 수정이 가능합니다.");


        Post post = findEntityById(id);

        post.update(dto);

        postRepository.saveAndFlush(post);

        return post.toDTO();
    }

    @Transactional
    public void deleteById(Principal principal, String member_id, Long id){

        if(!member_id.equals(principal.getName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"자신의 블로그에만 수정이 가능합니다.");


        Post post = findEntityById(id);

        postRepository.delete(post);
    }

    Member findEntityByMemberId(String member_id){
        return memberRepository.findByMemberId(member_id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 팀은 찾을 수 없습니다."));
    }

    Post findEntityById(Long id){
        return postRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 게시글은 존재하지 않습니다."));
    }

}
