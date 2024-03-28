package com.VersatileDataProcessor.DataConsumer.models.apiMessages;

import com.VersatileDataProcessor.DataConsumer.models.MessageType;
import com.VersatileDataProcessor.DataConsumer.models.messageSupport.randomUser.RandomUser;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(as = RandomUserApiMessage.class)
public class RandomUserApiMessage implements ApiMessageInterface{
    private String id = UUID.randomUUID().toString();
    @Getter
    private MessageType messageType = MessageType.RANDOM_USER;

    private List<RandomUser> results;
}