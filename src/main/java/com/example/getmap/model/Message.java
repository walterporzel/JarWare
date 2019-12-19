package com.example.getmap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Message {
    private final UUID id;
    @NotBlank
    private final String message;

    public Message(@JsonProperty("id") UUID id,
                   @JsonProperty("message") String message) {
        this.id = id;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
