package com.VersatileDataProcessor.ElasticsearchWriter.models.messageSupport.randomUser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@JsonDeserialize(as = ID.class)
public class ID {
    private String name, value;
}
