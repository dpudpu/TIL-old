package com.example.onetomany.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class OneToManyTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Test
    void name() {

        Article article = new Article("foo");

        article.addImage(new Image("foo 1"));
        article.addImage(new Image("foo 2"));
        article.addImage(new Image("foo 3"));
        article.addImage(new Image("foo 4"));

        articleRepository.saveAndFlush(article);


        System.out.println("--------------------");

        Image image = imageRepository.findById(1L).get();
        article.getImages().remove(image);
        testEntityManager.flush();
    }
}