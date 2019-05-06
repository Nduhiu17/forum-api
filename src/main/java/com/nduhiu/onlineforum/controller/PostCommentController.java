package com.nduhiu.onlineforum.controller;

import com.nduhiu.onlineforum.exception.ResourceNotFoundException;
import com.nduhiu.onlineforum.model.PostComment;
import com.nduhiu.onlineforum.repository.ForumPostRepository;
import com.nduhiu.onlineforum.repository.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostCommentController {

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @GetMapping("/api/v1/posts/{postId}/comments")
    public List<PostComment> getCommentsBypostId(@PathVariable Long postId) {
        return postCommentRepository.findByForumPostId(postId);
    }

}
