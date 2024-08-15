package com.elasticsearch.services;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.elasticsearch.models.JobOffer;
import com.elasticsearch.repository.JobOfferRepository;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public void init() {
        // Code to fetch job offers from your database and save them to Elasticsearch
        // Example:
        // List<JobOffer> jobOffers = fetchJobOffersFromDatabase();
        // jobOfferRepository.saveAll(jobOffers);
    }

    public List<JobOffer> searchJobOffers(String keyword) {
        return jobOfferRepository.findByCityOrPostalCodeOrRegion(keyword, keyword, keyword);
    }

    @Autowired
    private RestHighLevelClient client;



}
