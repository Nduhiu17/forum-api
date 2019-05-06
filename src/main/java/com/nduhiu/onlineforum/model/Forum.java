package com.nduhiu.onlineforum.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forums")
public class Forum extends AuditModel {
    @Id
    @GeneratedValue(generator = "forum_generator")
    @SequenceGenerator(
            name = "forum_generator",
            sequenceName = "forum_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 400)
    private String title;




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
}