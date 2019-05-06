package com.nduhiu.onlineforum.controller;

import com.nduhiu.onlineforum.exception.ResourceNotFoundException;
import com.nduhiu.onlineforum.model.Forum;
import com.nduhiu.onlineforum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;

    @GetMapping("/api/v1/forums")
    public Page<Forum> getForums(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }


    @PostMapping("/api/v1/forums")
    public Forum createForum(@Valid @RequestBody Forum forum) {
        return forumRepository.save(forum);
    }

    @PutMapping("/api/v1/forums/{forumId}")
    public Forum updateForum(@PathVariable Long forumId,
                             @Valid @RequestBody Forum forumRequest) {
        return forumRepository.findById(forumId)
                .map(forum -> {
                    forum.setTitle(forumRequest.getTitle());
                    return forumRepository.save(forum);
                }).orElseThrow(() -> new ResourceNotFoundException("Forum not found with id " + forumId));
    }
    @GetMapping("/api/v1/forums/{forumId}")
    public Forum getForumById(@PathVariable Long forumId) {
        return forumRepository.findById(forumId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + forumId));
    }

    @DeleteMapping("/api/v1/forums/{forumId}")
    public ResponseEntity<?> deleteForum(@PathVariable Long forumId) {
        return forumRepository.findById(forumId)
                .map(forum -> {
                    forumRepository.delete(forum);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + forumId));
    }
}