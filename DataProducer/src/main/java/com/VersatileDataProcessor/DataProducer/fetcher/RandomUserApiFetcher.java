package com.VersatileDataProcessor.DataProducer.fetcher;

import com.VersatileDataProcessor.DataProducer.models.apiMessages.RandomUserApiMessage;
import com.VersatileDataProcessor.DataProducer.service.ApiMessageProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class RandomUserApiFetcher implements DataFetcherInterface {
    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private ApiMessageProducerService producerService;

    @Override
    public void fetchData() {
        String uri = "https://randomuser.me/api/1.4?results=5&noinfo";;

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
