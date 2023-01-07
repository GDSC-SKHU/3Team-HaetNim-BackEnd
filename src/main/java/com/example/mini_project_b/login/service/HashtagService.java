package com.example.mini_project_b.login.service;


import com.example.mini_project_b.login.domain.Hashtag;
import com.example.mini_project_b.login.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HashtagService {
    private final HashTagRepository hashTagRepository;

    public ResponseEntity<?> getAllHashTags() {
        return new ResponseEntity<>(hashTagRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findHashTagById(Long id) {
        Optional<Hashtag> hashTagOptional = hashTagRepository.findById(id);

        if (hashTagOptional.isPresent()) {
            return new ResponseEntity<>(hashTagOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> saveHashTag(Hashtag hashTag) {
        return new ResponseEntity<>(hashTagRepository.save(hashTag),
                HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteHashTag(Long id) {
        Optional<Hashtag> hashTagOptional = hashTagRepository.findById(id);

        if (hashTagOptional.isPresent()) {
            hashTagRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateHashTag(Long id, Hashtag hashTag) {
        Optional<Hashtag> hashTagOptional = hashTagRepository.findById(id);

        if (hashTagOptional.isPresent()) {
            Hashtag updatedHashTag = hashTagOptional.get();
            updatedHashTag.setTag(hashTag.getTag());
            return new ResponseEntity<>(hashTagRepository.save(updatedHashTag), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Optional<Hashtag> findHashTagByTag(String tag) {
        return hashTagRepository.findHashTagByTag(tag);
    }

}