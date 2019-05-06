package com.nduhiu.onlineforum.repository;

import com.nduhiu.onlineforum.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findByForumPostId(Long forumPostId);
}