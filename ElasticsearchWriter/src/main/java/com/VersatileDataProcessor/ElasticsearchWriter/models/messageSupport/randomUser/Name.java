package com.VersatileDataProcessor.ElasticsearchWriter.models.messageSupport.randomUser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@JsonDeserialize(as = Name.class)
public class Name {
    private String title, first, last;
}
