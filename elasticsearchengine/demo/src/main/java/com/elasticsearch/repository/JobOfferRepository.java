package com.elasticsearch.repository;

import com.elasticsearch.models.JobOffer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch.repository")

public interface JobOfferRepository extends ElasticsearchRepository<JobOffer, String> {
    // with elasticsearch the method name is enough for the search !
    List<JobOffer> findByCityOrPostalCodeOrRegion(String city, String postalCode, String region);

}
