package com.elasticsearch.services;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.models.JobOffer;
import com.elasticsearch.models.JobOfferJPA;
import com.elasticsearch.RepoJPA.JobOfferJPARepository;
import com.elasticsearch.repository.JobOfferRepository;

import java.io.IOException;

@Service
public class IndexingService {

    @Autowired
    private JobOfferJPARepository jobOfferJPARepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient; // Use the RestHighLevelClient

    public void indexAllJobOffers() {
        // Fetch all job offers from PostgreSQL
        Iterable<JobOfferJPA> jobOffers = jobOfferJPARepository.findAll();

        // Index each job offer in Elasticsearch
        for (JobOfferJPA jobOfferJPA : jobOffers) {
            // Convert JobOfferJPA to JobOffer
            JobOffer jobOffer = new JobOffer();
            jobOffer.setId(jobOfferJPA.getId().toString()); // Ensure ID is string in Elasticsearch
            jobOffer.setTitle(jobOfferJPA.getTitle());
            jobOffer.setDescription(jobOfferJPA.getDescription());
            jobOffer.setCity(jobOfferJPA.getCity());
            jobOffer.setPostalCode(jobOfferJPA.getPostalCode());
            jobOffer.setRegion(jobOfferJPA.getRegion());
            // Set other fields as necessary

            // Save to Elasticsearch
            jobOfferRepository.save(jobOffer);
        }
    }

    public void indexTestDocument() {
        // Create a JobOffer instance with mock data
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId("1");
        jobOffer.setTitle("Test Job");
        jobOffer.setDescription("A simple test job");
        jobOffer.setCity("Nice");
        jobOffer.setPostalCode("06000");
        jobOffer.setRegion("Provence-Alpes-Côte d'Azur");

        // Save to Elasticsearch
        jobOfferRepository.save(jobOffer);

        System.out.println("Test document indexed successfully.");
    }
}
