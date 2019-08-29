package org.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class Example06Exists {
    /**
     * Exists API
     */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        //인덱스 명
        String INDEX_NAME = "movie_auto_java";

        //문서 키값
        String _id = "1";

        GetRequest getRequest = new GetRequest(INDEX_NAME)
                .id(_id);

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
        client.close();
    }
}