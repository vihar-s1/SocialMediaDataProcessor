package com.VersatileDataProcessor.DataConsumer.models.processedMessages;


import com.VersatileDataProcessor.DataConsumer.models.messageSupport.Joke;
import com.VersatileDataProcessor.DataConsumer.models.MessageType;
import com.VersatileDataProcessor.DataConsumer.models.apiMessages.JokeApiMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class JokeMessage implements ProcessedMessageInterface{
    private String id;
    private String category;
    private Set<String> tags;
    private List<String> statements;
    @Getter
    private MessageType messageType = MessageType.JOKE;

    private JokeMessage() {
        this.tags = new HashSet<>();
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public static List<JokeMessage> processApiMessage(JokeApiMessage apiMessage){
        if (apiMessage == null || apiMessage.isError() || apiMessage.getAmount() == 0) return Collections.emptyList();

        List<Joke> jokes = apiMessage.getJokes();

        List<JokeMessage> jokeMessages = new ArrayList<>();

        for (int i = 0; i < jokes.size(); i++) {
            Joke joke = jokes.get(i);

            JokeMessage jokeMsg = new JokeMessage();

            jokeMsg.setId( apiMessage.getId() + "-" + i );

            jokeMsg.setStatements(Arrays.asList(
                    joke.getJoke().split("(?<=[.!?])\\s+")
            ));

            joke.getFlags().forEach((key, val) -> {
                if (val) jokeMsg.addTag(key);
            });

            jokeMsg.setCategory(joke.getCategory());

            jokeMessages.add(jokeMsg);
        }

        return jokeMessages;
    }
}
