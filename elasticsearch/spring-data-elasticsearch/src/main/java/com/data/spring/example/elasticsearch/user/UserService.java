package com.data.spring.example.elasticsearch.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByName(final String name) {
        return userRepository.findByName(name);
    }

    public User save(final User user){

        return userRepository.save(user);
    }

}
