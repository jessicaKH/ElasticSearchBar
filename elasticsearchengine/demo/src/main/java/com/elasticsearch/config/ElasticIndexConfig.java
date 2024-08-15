package com.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.xcontent.XContentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticIndexConfig {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    public void createIndex() throws IOException {
        String indexName = "joboffers2";

        // Define index settings as JSON string
        /*String settings = "{\n" +
                "  \"settings\": {\n" +
                "    \"analysis\": {\n" +
                "      \"analyzer\": {\n" +
                "        \"autocomplete\": {\n" +
                "          \"type\": \"custom\",\n" +
                "          \"tokenizer\": \"standard\",\n" +
                "          \"filter\": [\"lowercase\"]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Define mappings as JSON string
        String mappings = "{\n" +
                "  \"properties\": {\n" +
                "    \"name\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"autocomplete\"\n" +
                "    }\n" +
                "  }\n" +
                "}";*/

        String settings = "{\n" +
                "  \"settings\": {\n" +
                "    \"analysis\": {\n" +
                "      \"analyzer\": {\n" +
                "        \"autocomplete\": {\n" +
                "          \"type\": \"custom\",\n" +
                "          \"tokenizer\": \"autocomplete_tokenizer\",\n" +
                "          \"filter\": [\"lowercase\"]\n" +
                "        }\n" +
                "      },\n" +
                "      \"tokenizer\": {\n" +
                "        \"autocomplete_tokenizer\": {\n" +
                "          \"type\": \"edge_ngram\",\n" +
                "          \"min_gram\": 1,\n" +
                "          \"max_gram\": 20,\n" +
                "          \"token_chars\": [\"letter\", \"digit\"]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Define mappings as JSON string
        String mappings = "{\n" +
                "  \"properties\": {\n" +
                "    \"title\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"autocomplete\",\n" +
                "      \"search_analyzer\": \"standard\"\n" +
                "    },\n" +
                "    \"description\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"standard\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Create the index request
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.source(settings, XContentType.JSON);
        createIndexRequest.mapping(mappings, XContentType.JSON);

        // Create the index
        CreateIndexResponse createIndexResponse = elasticsearchClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println("Index creation response: " + createIndexResponse);
    }
}
