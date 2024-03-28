package com.VersatileDataProcessor.DataConsumer.models.messageSupport.randomUser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Login {
    private String uuid, username, password, salt, md5, sha1, sha256;
}
