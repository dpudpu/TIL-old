package com.data.spring.example.elasticsearch.user;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "user" )
public class User {

    @Id
    private String id;
    private String name;
}
