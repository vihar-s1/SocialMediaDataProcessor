package com.VersatileDataProcessor.DataConsumer.models.apiMessages;

import com.VersatileDataProcessor.DataConsumer.models.messageSupport.Joke;
import com.VersatileDataProcessor.DataConsumer.models.MessageType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonDeserialize(as = JokeApiMessage.class)
public class JokeApiMessage implements ApiMessageInterface {
    private String id;

    @Getter
    private final MessageType messageType = MessageType.JOKE;

    private boolean error;
    private int amount;
    private List<Joke> jokes;
}
