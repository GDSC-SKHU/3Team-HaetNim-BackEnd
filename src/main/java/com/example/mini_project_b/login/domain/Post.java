package com.example.mini_project_b.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "img", nullable = true,length = 150)
    private String img;

    @Column(name = "disclosure", nullable = false)
    private boolean disclosure;

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="post_hashtag", joinColumns=@JoinColumn(name="post_id"), inverseJoinColumns=@JoinColumn(name="hashtag_id"))
    private List<Hashtag> hashtags;

}
