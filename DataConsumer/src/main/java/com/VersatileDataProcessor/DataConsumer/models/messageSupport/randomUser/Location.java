package com.VersatileDataProcessor.DataConsumer.models.messageSupport.randomUser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Location {
    private Street street;
    private String city, state, country;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;


    @Getter @Setter @ToString
    static class Street {
        private  int number;
        private String name;
    }

    @Getter @Setter @ToString
    static class Coordinates {
        private String latitude, longitude;
    }

    @Getter @Setter @ToString
    static class Timezone {
        private String offset, description;
    }
}
