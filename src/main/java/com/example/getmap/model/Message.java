package com.example.getmap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.DataAmount;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    @Column(name = "message")
    private String message;

    public Message(@JsonProperty("id") UUID id,
                   @JsonProperty("message") String message) {
        this.id = id;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public Message(){}
}
