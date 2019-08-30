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
        User user = new User();
        user.setName("name");

        User savedUser = userService.save(user);

        System.out.println(savedUser);
    }

    @Test
    public void save() {
    }
}