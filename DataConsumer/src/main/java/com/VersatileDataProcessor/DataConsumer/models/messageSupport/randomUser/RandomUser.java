package com.VersatileDataProcessor.DataConsumer.models.messageSupport.randomUser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RandomUser {
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

