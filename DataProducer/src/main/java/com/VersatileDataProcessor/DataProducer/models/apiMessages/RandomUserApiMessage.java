package com.VersatileDataProcessor.DataProducer.models.apiMessages;

import com.VersatileDataProcessor.DataProducer.models.MessageType;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserApiMessage implements ApiMessageInterface{
    private String id = UUID.randomUUID().toString();
    @Getter
    private MessageType messageType = MessageType.RANDOM_USER;

    private List<RandomUser> results;
}

@Getter @Setter @ToString
class RandomUser {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DateOfBirth dob;
    private Registered registered;
    private String phone, cell;
    private ID id;
    private Picture picture;
    private String nat;
}

@Getter @Setter @ToString
class Name {
    private String title, first, last;
}

@Getter @Setter @ToString
class Location {
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

@Getter @Setter @ToString
class Login {
    private String uuid, username, password, salt, md5, sha1, sha256;
}

@Getter @Setter @ToString
class DateOfBirth {
    private String date;
    private int age;
}

@Getter @Setter @ToString
class Registered {
    private String date;
    private int age;
}

@Getter @Setter @ToString
class ID {
    private String name, value;
}

@Getter @Setter @ToString
class Picture {
    private String large, medium, thumbnail;
}
