package org.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class Example03 {
    /**
     * 인덱스 오픈 및 종료
     */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // Index명
        String INDEX_NAME = "movie_rest";


        // Index Open
        OpenIndexRequest requestOpen = new OpenIndexRequest(INDEX_NAME);

        OpenIndexResponse openIndexResponse =
                client.indices().open(requestOpen, RequestOptions.DEFAULT);

        boolean ackOpen = openIndexResponse.isAcknowledged();
        System.out.println(ackOpen);


        // Index Close
        CloseIndexRequest requestClose = new CloseIndexRequest(INDEX_NAME);

        AcknowledgedResponse closeIndexResponse =
                client.indices().close(requestClose, RequestOptions.DEFAULT);

        boolean ackClose = closeIndexResponse.isAcknowledged();

        System.out.println(ackClose);
        client.close();
    }
}