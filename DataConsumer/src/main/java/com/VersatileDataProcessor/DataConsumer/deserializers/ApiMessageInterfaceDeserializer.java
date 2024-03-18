package com.VersatileDataProcessor.DataConsumer.deserializers;


import com.VersatileDataProcessor.DataConsumer.models.ApiMessages.ApiMessageInterface;
import com.VersatileDataProcessor.DataConsumer.models.ApiMessages.MockApiMessage;
import com.VersatileDataProcessor.DataConsumer.models.MessageType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class ApiMessageInterfaceDeserializer extends JsonDeserializer<ApiMessageInterface> {
    @Override
    public ApiMessageInterface deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);

        // currently only one type is there
        String messageType = root.get("messageType").asText();

        return switch (MessageType.valueOf(messageType)) {
            case TUMBLR -> null;
            case REDDIT -> null;
            case WEATHER -> null;
            case RANDOM_USER -> null;
            case MOCK -> mapper.readValue(root.toString(), MockApiMessage.class);
        };
    }
}