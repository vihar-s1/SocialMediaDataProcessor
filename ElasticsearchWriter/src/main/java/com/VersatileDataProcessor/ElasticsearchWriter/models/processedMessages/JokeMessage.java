package com.VersatileDataProcessor.ElasticsearchWriter.models.processedMessages;

import com.VersatileDataProcessor.ElasticsearchWriter.models.MessageType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Component
@JsonDeserialize(as = JokeMessage.class)
@Document(indexName = "jokes")
@TypeAlias("JokeMessage")
public class JokeMessage implements MessageInterface {
    private String id;
    private String category;
    private Set<String> tags;
    private List<String> statements;
    private MessageType messageType = MessageType.JOKE;
}
