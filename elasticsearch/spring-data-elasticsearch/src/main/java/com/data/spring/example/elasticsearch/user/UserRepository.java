package com.data.spring.example.elasticsearch.user;


import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {
    List<User> findByName(String name);
}
