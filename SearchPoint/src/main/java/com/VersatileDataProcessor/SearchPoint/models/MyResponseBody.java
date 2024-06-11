package com.VersatileDataProcessor.SearchPoint.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MyResponseBody<T> {
    private String message;
    private Boolean success;
    private T data;
}
