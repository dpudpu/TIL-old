package org.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class Example07Delete {
    /**
     * DELETE API
     * */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        //인덱스 명
        String INDEX_NAME = "movie_rest";

        //문서 키값
        String _id = "1";

        DeleteRequest request = new DeleteRequest(INDEX_NAME)
                .id(_id);

        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteResponse);
        System.out.println(deleteResponse.getResult());
        client.close();
    }
}