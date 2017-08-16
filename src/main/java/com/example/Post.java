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

    private String image;

    private String text;

    @ManyToOne
    private Account author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() { return image; }

    public String getText() {
        return text;
    }

    Post(String title, String image, String text, Account account) {
        this.title = title;
        this.image = image;
        this.text = text;
        this.author = account;
    }

    Post(){

    }

    public String getAuthor() {
        return author.getUsername();
    }
}
