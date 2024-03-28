package com.VersatileDataProcessor.DataConsumer.models.messageSupport;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Joke {
    private String category;
    private String type;
    private String joke;
    private Map<String, Boolean> flags;
}
