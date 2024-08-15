package com.elasticsearch;

import com.elasticsearch.services.IndexingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IndexingService indexingService) {
		return args -> {
			// Call the indexAllJobOffers method
			//indexingService.indexTestDocument();
		};
	}
}
