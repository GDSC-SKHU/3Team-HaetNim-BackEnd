package com.example.mini_project_b.login.domain.DTO;

import com.example.mini_project_b.login.domain.Member;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;

    @NotBlank
    @Size(max = 150)
    private String title;

    @NotBlank
    private String content;

    private String img;

    @NotBlank
    private boolean disclosure;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    private MemberJoinDto memberJoinDto;
}
