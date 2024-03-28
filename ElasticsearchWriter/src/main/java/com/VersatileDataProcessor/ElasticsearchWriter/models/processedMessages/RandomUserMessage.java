package com.VersatileDataProcessor.ElasticsearchWriter.models.processedMessages;

import com.VersatileDataProcessor.ElasticsearchWriter.models.MessageType;
import com.VersatileDataProcessor.ElasticsearchWriter.models.messageSupport.randomUser.ID;
import com.VersatileDataProcessor.ElasticsearchWriter.models.messageSupport.randomUser.Name;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Component
@JsonDeserialize(as = RandomUserMessage.class)
@Document(indexName = "random-users")
@TypeAlias("RandomUserMessage")
public class RandomUserMessage implements MessageInterface{
    private String id;
    @Getter
    private MessageType messageType = MessageType.RANDOM_USER;

    private String gender,email, dob, registrationDate, phone, cell, picture;
    private Name name;
    private ID userId;
}
