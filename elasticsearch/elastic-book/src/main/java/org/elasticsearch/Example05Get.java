package org.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;

public class Example05Get {
    /**
     * GET API
     */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // 인덱스명
        String INDEX_NAME = "movie_auto_java";


        // 문서 키값
        String _id = "1";

        // 요청
        GetRequest request = new GetRequest(INDEX_NAME)
                .id(_id);

        // 응답
        GetResponse response = client.get(request, RequestOptions.DEFAULT);

        // 응답의 결과를 Map 형태로 제공받는다.
        if (response.isExists()) {
            long version = response.getVersion();
            Map<String, Object> sourceAsMap = response.getSourceAsMap();
            System.out.println(sourceAsMap.values());

        } else {
            System.out.println("결과가 존재하지 않습니다.");
        }

        client.close();
    }
}