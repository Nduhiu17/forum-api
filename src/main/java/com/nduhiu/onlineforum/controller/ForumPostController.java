package com.nduhiu.onlineforum.controller;

import com.nduhiu.onlineforum.exception.ResourceNotFoundException;
import com.nduhiu.onlineforum.model.ForumPost;
import com.nduhiu.onlineforum.repository.ForumPostRepository;
import com.nduhiu.onlineforum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ForumPostController {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ForumRepository forumRepository;


    @PostMapping("/api/v1/forums/{forumId}/posts")
    public ForumPost addForumPost(@PathVariable Long forumId,
                                 @Valid @RequestBody ForumPost forumPost) {
        return forumRepository.findById(forumId)
                .map(forum -> {
                    forumPost.setForum(forum);
                    return forumPostRepository.save(forumPost);
                }).orElseThrow(() -> new ResourceNotFoundException("Forum not found with id " + forumId));
    }



    @PutMapping("/api/v1/forums/{forumId}/posts/{postId}")
    public ForumPost updateForumPost(@PathVariable Long forumId,
                                   @PathVariable Long postId,
                                   @Valid @RequestBody ForumPost postRequest) {
        if(!forumRepository.existsById(forumId)) {
            throw new ResourceNotFoundException("Forum not found with id " + forumId);
        }

        return forumPostRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.getTitle());
                    post.setBody(postRequest.getBody());
                    return forumPostRepository.save(post);
                }).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
    }




    @GetMapping("/api/v1/forums/{forumId}/posts")
    public List<ForumPost> getQuestionsByForumId(@PathVariable Long forumId) {
        return forumPostRepository.findByForumId(forumId);
    }

    @DeleteMapping("/api/v1/posts/{postId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long postId) {
        return forumPostRepository.findById(postId)
                .map(question -> {
                    forumPostRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
    }
}