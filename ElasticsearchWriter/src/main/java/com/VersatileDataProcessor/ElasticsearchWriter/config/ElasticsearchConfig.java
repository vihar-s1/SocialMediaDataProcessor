package com.VersatileDataProcessor.ElasticsearchWriter.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;
import org.springframework.lang.NonNull;

@Configuration
public class ElasticsearchConfig extends ReactiveElasticsearchConfiguration {

    @Value(value = "${spring.elasticsearch.hostname}")
    private String hostName;
    @Value(value = "${spring.elasticsearch.port}")
    private int port;

    @Override
    public @NonNull ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(hostName + ":" + port)
                .withSocketTimeout(60_000) // Set socket timeout (in milliseconds)
                .withConnectTimeout(30_000) // Set connection timeout (in milliseconds)
                .build();
    }
}
