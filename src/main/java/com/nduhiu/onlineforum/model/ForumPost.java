package com.nduhiu.onlineforum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forumposts")
public class ForumPost extends AuditModel {
    @Id
    @GeneratedValue(generator = "forumpost_generator")
    @SequenceGenerator(
            name = "forumpost_generator",
            sequenceName = "forumpost_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "forum_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Forum forum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}