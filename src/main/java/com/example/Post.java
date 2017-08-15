package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String text;

    @ManyToOne
    private Account author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    Post(String title, String text, Account account) {
        this.title = title;
        this.text = text;
        this.author = account;
    }

    Post(){

    }

    public String getAuthor() {
        return author.getUsername();
    }
}
