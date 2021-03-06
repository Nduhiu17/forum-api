package com.nduhiu.onlineforum.repository;

import com.nduhiu.onlineforum.model.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
    List<ForumPost> findByForumId(Long forumId);
}
