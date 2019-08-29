package org.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class Example01 {

    /**
     * 인덱스 생성 및 매핑생성
     */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // Index명
        String INDEX_NAME = "movie_rest";


        // 매핑정보
        XContentBuilder indexBuilder = jsonBuilder()
                .startObject()
                    .startObject("properties")
                        .startObject("movieCd")
                            .field("type", "keyword")
                            .field("store", "true")
                        .endObject()
                        .startObject("movieNm")
                            .field("type", "text")
                            .field("store", "true")
                        .endObject()
                        .startObject("movieNmEn")
                            .field("type", "text")
                            .field("store", "true")
                        .endObject()
                    .endObject()
                .endObject();

        // 매핑 설정
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
        request.mapping(indexBuilder);

        // Alias 설정
        String ALIAS_NAME = "moive_auto_alias";
        request.alias(new Alias(ALIAS_NAME));

        // 인덱스 생성
        CreateIndexResponse createIndexResponse =
                client.indices().create(request, RequestOptions.DEFAULT);


        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("acknowledged:" + acknowledged);
        client.close();
    }
}
