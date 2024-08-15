package com.elasticsearch.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import com.elasticsearch.RepoJPA.JobOfferJPARepository;
import com.elasticsearch.models.JobOffer;
import com.elasticsearch.models.JobOfferJPA;
import com.elasticsearch.repository.JobOfferRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JobOfferIndexService {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    @Autowired
    private JobOfferJPARepository jobOfferRepository;

    /*public void indexJobOffers() throws IOException {
        // Fetch job offers from the database
        List<JobOfferJPA> jobOffers =  jobOfferRepository.findAll();

        for (JobOfferJPA jobOffer : jobOffers) {
            IndexRequest indexRequest = new IndexRequest.Builder()
                    .index("joboffers")
                    .id(jobOffer.getId().toString())
                    .document(jobOffer)
                    .build();

            elasticsearchClient.index(indexRequest);
        }
    }*/
}
