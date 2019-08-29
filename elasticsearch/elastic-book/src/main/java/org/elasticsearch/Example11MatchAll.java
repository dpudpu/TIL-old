package org.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Map;

public class Example11MatchAll {
    /**
     * Match ALL API
     * */
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // 인덱스명
        String INDEX_NAME = "movie_rest";

        // 필드명
        String FIELD_NAME = "movieCd";


        // 검색 쿼리 설정
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchSourceBuilder.sort(new FieldSortBuilder(FIELD_NAME).order(SortOrder.DESC));

        // 요청
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);


        // 응답
        SearchResponse searchResponse = client.search(searchRequest,RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit hit : searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(sourceAsMap.values());
        }

        client.close();
    }
}