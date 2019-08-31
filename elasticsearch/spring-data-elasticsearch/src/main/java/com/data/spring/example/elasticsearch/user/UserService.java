package com.data.spring.example.elasticsearch.user;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private RestHighLevelClient client;

    public UserService(final RestHighLevelClient client) {
        this.client = client;
    }

    public boolean testMe() {
        boolean exists = false;
        try {
            //인덱스 명
            String INDEX_NAME = "movie_rest";

            //문서 키값
            String _id = "1";

            GetRequest getRequest = new GetRequest(INDEX_NAME)
                    .id(_id);


            exists = client.exists(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exists;
    }
}
