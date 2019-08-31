package com.data.spring.example.elasticsearch.user;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByName() {
        System.out.println(userService.testMe());
    }

    @Test
    public void save() {
    }
}