package com.demo.conf;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.Resource;

@Configuration
//@PropertySource(value = "classpath:config/elasticsearch.properties")
public class ElasticsearchConfiguration {

    @Resource
    private Environment environment;

    @Bean
    public Client client() {
        Settings settings = Settings.builder()
                .put("elasticsearch_cluster_name", environment.getProperty("elasticsearch_cluster_name"))
                .put("elasticsearch_cluster_nodes", environment.getProperty("elasticsearch_cluster_nodes"))
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}