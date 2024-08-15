package com.elasticsearch.config;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http") // Adjust host and port as needed
        );

        builder.setHttpClientConfigCallback(httpClientBuilder ->
                httpClientBuilder.addInterceptorFirst((HttpRequestInterceptor) (request, context) -> {
                    request.addHeader(HttpHeaders.ACCEPT, "application/vnd.elasticsearch+json;compatible-with=7");
                    request.addHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.elasticsearch+json;compatible-with=7");
                })
        );

        // Additional configuration options can be set here if needed
        // For example, adding request configuration, error listener, etc.
        // builder.setDefaultHeaders(...);
        // builder.setRequestConfigCallback(...);
        // builder.setFailureListener(...);

        return new RestHighLevelClient(builder);
    }
}
