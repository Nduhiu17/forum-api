package com.nduhiu.onlineforum.repository;




import com.nduhiu.onlineforum.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
}