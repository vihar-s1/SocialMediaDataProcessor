package com.VersatileDataProcessor.DataConsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DataConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataConsumerApplication.class, args);
	}

}
