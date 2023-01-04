package com.example.mini_project_b.login.domain;


import com.example.mini_project_b.follow.DTO.Follow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member implements UserDetails {
    @GeneratedValue
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name="profileImg", nullable = true,length = 200)
    private String profileImg;

    @Column(name="nickname",nullable = false,length = 100)
    private String nickname;

    @Column(name="statusMessage",nullable = false,length = 100)
    private String statusMessage;

    //    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name="follow")
//    private List<Follow> follows;
    @OneToMany(mappedBy = "follower",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Follow> followerList;

    @OneToMany(mappedBy = "followee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<Follow> followeeList;

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="post_likes", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="post_id"))
    private List<Member> members;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public String getUsername() {
        return getUsername();
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
/**
 * - user : post = 1 : n
 * - user : user_post_like = 1: n
 * - user : follow = n : m
 * - post : post_like = 1 : n
 */
