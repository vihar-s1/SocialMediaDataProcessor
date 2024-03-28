package com.VersatileDataProcessor.DataConsumer.deserializers;


import com.VersatileDataProcessor.DataConsumer.models.MessageType;
import com.VersatileDataProcessor.DataConsumer.models.apiMessages.ApiMessageInterface;
import com.VersatileDataProcessor.DataConsumer.models.apiMessages.JokeApiMessage;
import com.VersatileDataProcessor.DataConsumer.models.apiMessages.MockApiMessage;
import com.VersatileDataProcessor.DataConsumer.models.apiMessages.RandomUserApiMessage;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class ApiMessageInterfaceDeserializer extends JsonDeserializer<ApiMessageInterface> {
    @Override
    public ApiMessageInterface deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper. readTree(jsonParser);

        // currently only one type is there
        String messageType = root.get("messageType").asText();

        return switch (MessageType.valueOf(messageType)) {
            case JOKE -> mapper.readValue(root.toString(), JokeApiMessage.class);
            case RANDOM_USER -> mapper.readValue(root.toString(), RandomUserApiMessage.class);
            case MOCK -> mapper.readValue(root.toString(), MockApiMessage.class);
        };
    }
}
