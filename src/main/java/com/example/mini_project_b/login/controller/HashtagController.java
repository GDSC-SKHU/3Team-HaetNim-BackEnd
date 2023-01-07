package com.example.mini_project_b.login.controller;

import com.example.mini_project_b.login.domain.Hashtag;
import com.example.mini_project_b.login.service.HashtagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hashtag")
@RequiredArgsConstructor
public class HashtagController {

    private final HashtagService hashtagService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllHashTags() {
        return hashtagService.getAllHashTags();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findHashTagById(@PathVariable Long id) {
        return hashtagService.findHashTagById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<?> saveHashTag(@RequestBody @Valid Hashtag hashtag) {
        return hashtagService.saveHashTag(hashtag);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHashTag(@PathVariable Long id) {
        return hashtagService.deleteHashTag(id);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateHashTag(@PathVariable Long id, @RequestBody @Valid Hashtag hashTag) {
        return hashtagService.updateHashTag(id, hashTag);
    }
}
