package com.elasticsearch.RepoJPA;

import com.elasticsearch.models.JobOfferJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories(basePackages = "com.elasticsearch.RepoJPA")

@Repository
public interface JobOfferJPARepository extends JpaRepository<JobOfferJPA, Long> {
}
