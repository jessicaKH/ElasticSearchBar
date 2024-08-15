package com.elasticsearch.services;

import com.elasticsearch.models.JobOffer;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobOfferSearchService {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    public List<JobOffer> search(String query) throws IOException {
        // Log the search query
        System.out.println("Executing search query: " + query);

        // Create a SearchRequest
        SearchRequest searchRequest = new SearchRequest("joboffers");

        // Build the search query
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(query, "name", "city", "postal_code", "region")
                .fuzziness("AUTO"));
        searchRequest.source(searchSourceBuilder);

        // Execute the search request
        SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

        // Extract the hits from the search response
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();

        System.out.println("Found " + searchHits.length + " results for query: " + query);

        // Process the search hits
        List<JobOffer> jobOffers = new ArrayList<>();
        for (SearchHit hit : searchHits) {
            // Convert each hit into a JobOffer object
            JobOffer jobOffer = convertToJobOffer(hit.getSourceAsString());
            jobOffers.add(jobOffer);
        }

        return jobOffers;
    }

    private JobOffer convertToJobOffer(String source) {
        // Implement JSON to JobOffer conversion here
        // This is a placeholder method. You can use Jackson or Gson to deserialize the JSON source to JobOffer.
        return null;
    }
}
