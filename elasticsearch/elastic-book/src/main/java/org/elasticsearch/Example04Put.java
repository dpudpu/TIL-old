package org.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class Example04Put {
    /**
     * 인덱스 데이터 추가
     */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // 인덱스 명
        String INDEX_NAME = "movie_rest";

        // 문서 키값
        String _id = "1";


        // 데이터 추가
        IndexRequest request = new IndexRequest(INDEX_NAME)
                .id(_id)
                .source(jsonBuilder()
                        .startObject()
                        .field("movieCd", "20173732")
                        .field("movieNm", "살아남은 ")
                        .field("movieNmEn", "Last Child")
                        .endObject()
                );


        // 결과 조회
        try {
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            System.out.println(response.getResult());
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {
                System.out.println("문서 생성에 실패하였습니다.");
            }
        }

        client.close();
    }
}