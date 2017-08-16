package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository,
                           PostRepository postRepository) {
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/1/" + a, "A description"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/2/" + a, "A description"));
                            postRepository.save(new Post("Titulo legal", "https://facebook.github.io/react/img/logo_og.png", "Contrary to popular belief, " +
                                    "Lorem Ipsum is not simply random text. It has roots in a piece of classical " +
                                    "Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, " +
                                    "a Latin professor at Hampden-Sydney College in Virginia.", account));
                        });
    }

}