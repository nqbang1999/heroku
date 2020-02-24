package com.bangelevenn.crudmaven.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 0, max = 50)
    private String title;


    @Length(min = 0, max = 1000)
    private String content;


    private LocalDateTime date;

    public Post() {
    }


    public Post(@Length(min = 0, max = 50) String title, @Length(min = 0, max = 1000) String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
