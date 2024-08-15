package com.elasticsearch.controller;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobOfferController {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    @GetMapping("/search")
    public String search(@RequestParam String query) throws IOException {
        SearchRequest searchRequest = new SearchRequest("joboffers2");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("city", query).fuzziness("AUTO"))
                .should(QueryBuilders.matchQuery("region", query).fuzziness("AUTO"))
                .should(QueryBuilders.matchQuery("title", query).fuzziness("AUTO"))
                .should(QueryBuilders.matchQuery("description", query).fuzziness("AUTO"))
        );
        sourceBuilder.size(5); // Adjust the number of results
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

        return searchResponse.toString(); // Serialize response as needed
    }
}
