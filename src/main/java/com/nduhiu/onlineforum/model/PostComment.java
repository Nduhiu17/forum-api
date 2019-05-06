package com.nduhiu.onlineforum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class PostComment extends AuditModel {
    @Id
    @GeneratedValue(generator = "comments_generator")
    @SequenceGenerator(
            name = "comments_generator",
            sequenceName = "comments_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "forumpost_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ForumPost forumPost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public void setForumPost(ForumPost forumPost) {
        this.forumPost = forumPost;
    }
}