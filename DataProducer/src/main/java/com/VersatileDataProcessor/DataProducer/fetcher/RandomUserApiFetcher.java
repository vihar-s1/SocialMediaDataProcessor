package com.versatileDataProcessor.dataProducer.fetcher;

import com.versatileDataProcessor.dataProducer.models.apiMessages.RandomUserApiMessage;
import com.versatileDataProcessor.dataProducer.service.ApiMessageProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class RandomUserApiFetcher implements DataFetcherInterface {
    private final WebClient.Builder webClientBuilder;
    private final ApiMessageProducerService producerService;

    public RandomUserApiFetcher(WebClient.Builder webClientBuilder, ApiMessageProducerService producerService) {
        this.webClientBuilder = webClientBuilder;
        this.producerService = producerService;
    }

    @Override
    public void fetchData() {
        String uri = "https://randomuser.me/api/1.4?results=5&noinfo";

        RandomUserApiMessage randomUserApiMessage = webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(RandomUserApiMessage.class)
                .block();

        log.info("Random User fetched by RandomUserApiFetcher");
        log.info("Sending the random user to Kafka");

        producerService.sendMessage(randomUserApiMessage);
    }
}
