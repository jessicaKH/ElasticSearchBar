package com.elasticsearch.config;

import com.elasticsearch.services.IndexingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner loadData(IndexingService indexingService) {
        return args -> {
            indexingService.indexAllJobOffers();
        };
    }
}
